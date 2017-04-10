package fr.ul.cad;

/**
 * Created by val on 06/04/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;


public class SoundFactory {

    private static SoundFactory instance = new SoundFactory();

    private Music mainThemeMusic;

    private SoundFactory() {
        mainThemeMusic = Gdx.audio.newMusic(Gdx.files.internal("core/assets/son/menu.mp3"));
    }

    public static SoundFactory getInstance() {
        return instance;
    }

    public Music getMainThemeMusic() {
        return mainThemeMusic;
    }
}
