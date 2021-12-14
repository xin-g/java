package cn.xin.demo01;

public class Main {
    public static MyEventListener listener = null;

    public static void main(String[] args) {
        listener = new MyEventListener();
        EventSource source = new EventSource("小白");
        source.addMyEventListener(listener);
        source.say("今天是个好天气");
        source.say("走走");

    }
}
