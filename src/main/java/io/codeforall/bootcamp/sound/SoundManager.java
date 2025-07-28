package io.codeforall.bootcamp.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class SoundManager {

    private Clip bgMusic;
    private boolean muted = false;

    private static SoundManager instance;

    private SoundManager() {}

    public static SoundManager getInstance() {
        if(instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void playBackground(String filename) {
        if(muted) return;

        try {
            URL soundURL = getClass().getResource("/audio/" + filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            bgMusic = AudioSystem.getClip();
            bgMusic.open(audioIn);
            bgMusic.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopBackground() {
        if(bgMusic != null && bgMusic.isRunning()) {
            bgMusic.stop();
        }
    }

    public void playEffect(String filename) {
        if(muted) return;

        try {
            URL soundURL = getClass().getResource("/audio/" + filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toogleMute() {
        muted = !muted;

        if(muted) {
            stopBackground();

        } else {
            playBackground("bg_music.wav");
        }
    }
}
