package cn.chen.适配器模式.AdvancedIpml;

import cn.chen.适配器模式.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
