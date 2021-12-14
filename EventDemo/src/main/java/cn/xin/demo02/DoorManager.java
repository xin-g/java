package cn.xin.demo02;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 事件源对象，在这里可以把它想象成一个控制门的开关的遥控器
 */
public class DoorManager {
    private Collection<DoorListener> listeners;

    /**
     * 添加事件
     */
    public void addDoorListener(DoorListener listener){
        if (listeners == null){
            listeners = new HashSet<>();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     */
    public void removeDoorListener(DoorListener listener){
        if (listeners == null){
            return;
        }
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened(){
        if (listeners == null) return;
        DoorEvent event = new DoorEvent(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed(){
        if (listeners == null) return;
        DoorEvent event = new DoorEvent(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event) {
        Iterator<DoorListener> iterator = listeners.iterator();
        while (iterator.hasNext()){
            DoorListener listener = iterator.next();
            listener.doorEvent(event);
        }
    }
}
