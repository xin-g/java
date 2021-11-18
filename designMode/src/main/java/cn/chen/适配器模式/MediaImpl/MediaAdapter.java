package cn.chen.适配器模式.MediaImpl;

import cn.chen.适配器模式.AdvancedIpml.Mp4Player;
import cn.chen.适配器模式.AdvancedIpml.VlcPlayer;
import cn.chen.适配器模式.AdvancedMediaPlayer;
import cn.chen.适配器模式.MediaPlayer;

/**
 * 实现了 MediaPlayer 接口的适配器类。
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
