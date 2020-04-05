package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.PlayState;


public class FlappyBird extends ApplicationAdapter {
    // Ниже создаются 3 статичные константы. Static означает,
    // что данные константы доступны в пределах всего проекта
    // и для их вызова НЕ НУЖНО создавать экземпляр класса
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Flappy Bird";

    private GameStateManager gsm; // создали экземпляр класса
    private SpriteBatch batch; // объект необходимый для отрисовки текстур
    private Music music;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        Gdx.gl.glClearColor(1,0,0,1);
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }
}
