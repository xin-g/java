package cn.chen;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    public static boolean connectionState = false;

    public static void main(String[] args) throws IOException {
        try {
            connect();
            if(!connectionState){
                connect();
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static void connect(){
        try {
            socket = new Socket("127.0.0.1",9999);
            connectionState = true;
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            new Thread(new ClientListen(socket,ois)).start();
            new Thread(new ClientSend(socket,oos)).start();
            new Thread(new ClientHeart(socket,oos)).start();

        } catch (Exception e) {
            e.printStackTrace();
            connectionState = false;
        }
    }

    public static void reconnent(){
        while (!connectionState){
            System.out.println("正在重新连接...........");
            connect();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientListen implements Runnable{
    private Socket socket;
    private ObjectInputStream ois;

    public ClientListen(Socket socket, ObjectInputStream ois) {
        this.socket = socket;
        this.ois = ois;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(ois.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ClientSend implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;

    public ClientSend(Socket socket, ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入需要发送的内容：");
                String string = scanner.nextLine();
                JSONObject object = new JSONObject();
                object.put("type","chat");
                object.put("msg",string);
                oos.writeObject(object);
                oos.flush();
            }
        } catch (Exception e) {
            try {
            socket.close();
            Client.connectionState = false;
            Client.reconnent();
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }
            e.printStackTrace();
        }
    }
}

class ClientHeart implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;

    public ClientHeart(Socket socket, ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            System.out.println("心跳包线程已启动");
            while (true){
                Thread.sleep(5000);
                JSONObject object = new JSONObject();
                object.put("type","heart");
                object.put("msg","心跳包");
                oos.writeObject(object);
                oos.flush();
            }
        } catch (Exception e) {
            try {
                socket.close();
                Client.connectionState = false;
                Client.reconnent();
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}