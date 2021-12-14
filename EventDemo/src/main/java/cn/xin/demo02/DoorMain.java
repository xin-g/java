package cn.xin.demo02;

public class DoorMain {
    public static void main(String[] args) {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());
        manager.addDoorListener(new DoorListener2());

        manager.fireWorkspaceOpened();
        manager.fireWorkspaceClosed();
    }
}
