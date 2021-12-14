package cn.xin.demo02;

import java.util.EventListener;

/**
 * 定义监听接口，负责监听DoorEvent
 */
public interface DoorListener extends EventListener {
    void doorEvent(DoorEvent event);
}
