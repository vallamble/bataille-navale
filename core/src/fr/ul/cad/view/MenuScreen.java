package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.acl.BatailleNavale;


public class MenuScreen extends ScreenAdapter {
	private BatailleNavale mygame;
	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;
	private FitViewport viewport;

	// creation de la premiere page
	public MenuScreen(BatailleNavale mygame) {
		this.mygame = mygame;
		this.batch = new SpriteBatch();
		this.img = new Texture("badlogic.jpg");
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(img.getWidth(), img.getHeight(), camera);
		this.camera.position.set(img.getWidth() / 2.0f, img.getHeight() / 2.0f, 0);
		this.camera.update();
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		// affiche de l'image
		this.batch.draw(img, 0, 0);
		this.batch.end();
		// on passe a l'ecran de jeu si on touche l'ecran sinon au bout de 4 sec
		if (Gdx.input.justTouched()) {
			this.batch.dispose();
			this.mygame.setGameScreen();
		}
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
