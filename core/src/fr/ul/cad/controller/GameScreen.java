package fr.ul.cad.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.cad.BattleShip;

public class GameScreen extends ScreenAdapter{
	private BattleShip mygame;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private FitViewport viewport;
    private float ppux = 48f, ppuy = 48f;

	public GameScreen(BattleShip batailleNavale) {
		this.mygame = mygame;
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), camera);
		this.camera.position.set(Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f, 0);
		this.camera.update();
	}
	
	
	
	
	
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		// affiche de l'image
		this.batch.end();
	}

	
	
	// maj de la camera
	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	// liberation
	public void dispose() {
		batch.dispose();
	}
}
