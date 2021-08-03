package cn.chen;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Socket服务器开始运行。。。");
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                //监听9999端口,该方法阻塞，等待连接，直到连接成功返回一个新的socket
                Socket socket = serverSocket.accept();
                new Thread(new ServerListen(socket)).start();
                new Thread(new ServerSend(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerListen implements Runnable{
    private Socket socket;

    ServerListen(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                System.out.println(ois.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ServerSend implements Runnable{
    private Socket socket;

    ServerSend(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入要发送的内容：");
                String string = scanner.nextLine();
                JSONObject object = new JSONObject();
                object.put("type","chat");
                object.put("msg",string);
                oos.writeObject(object);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}