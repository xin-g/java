package cn.xin.demo01;

import java.util.Vector;

/**
 * 事件源类。表明谁触发了事件，用于作为EventObject类的构造参数，
 * 在listener中作路由
 */
public class EventSource {
    private final String who;
    Vector<Object> listeners = new Vector<>();

    public EventSource(String who){
        this.who = who;
    }

    public String getActioner(){
        return who;
    }

    public void addMyEventListener(MyEventListener listener){
        listeners.add(listener);
    }

    /** 设定say方法能被MyEventListener对象监听到 */
    public void say(String words){
        System.out.println(this.getActioner() + "说：" + words);
        for (int i = 0; i < listeners.size(); i++) {
            MyEventListener listener = (MyEventListener) listeners.elementAt(i);
            //发布事件。当然应该事先规划say方法事件能发布给那些事件监听器。
            listener.onMyEvent(new EventClassOne(this));
        }
    }
}
