package cn.xin.demo02;

public class DoorListener1 implements DoorListener{
    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getDoorState() != null && "open".equals(event.getDoorState())){
            System.out.println("门1打开");
        }else {
            System.out.println("门1关闭");
        }
    }
}

class DoorListener2 implements DoorListener{

    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getDoorState() != null && "open".equals(event.getDoorState())){
            System.out.println("门2打开,同时开灯");
        }else {
            System.out.println("门2关闭,同时关灯");
        }
    }
}