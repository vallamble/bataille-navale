package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.cad.BatailleNavale;


public class MenuScreen extends ScreenAdapter {
	private BatailleNavale mygame;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private MenuChoice choice = MenuChoice.LANCER_PARTIE;
    public enum MenuChoice { LANCER_PARTIE, QUITTER }
    private float ppux = 48f, ppuy = 48f;

   


	// creation de la premiere page
	public MenuScreen(BatailleNavale mygame) {
		this.mygame = mygame;
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), camera);
		this.camera.position.set(Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f, 0);
		this.camera.update();
	}

	public void render(float delta) {
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
			batch.draw(TextureFactory.getInstance().getMenuBackground(),0,0);	
	        drawMenu();
		this.batch.end();
	}

	 private void drawMenu() {
	        if(choice == MenuScreen.MenuChoice.QUITTER)
	        	this.batch.draw(TextureFactory.getInstance().getMenuBoutonQuitterSelect(), 2*ppux,3*ppuy,10*ppux,ppuy);
	        else
	        	this.batch.draw(TextureFactory.getInstance().getMenuBoutonQuitter(), 2*ppux,3*ppuy,10*ppux,ppuy);
	       if(choice == MenuScreen.MenuChoice.LANCER_PARTIE)
	    	   this.batch.draw(TextureFactory.getInstance().getMenuBoutonLancerSelect(), 2*ppux,5*ppuy,10*ppux,ppuy);
	        else
	        	this.batch.draw(TextureFactory.getInstance().getMenuBoutonLancer(),  2*ppux,5*ppuy,10*ppux,ppuy);
	    }
	 
	// maj de la camera
	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	// liberation
	public void dispose() {
		batch.dispose();
	}

	public void setChoice() {
		 if(choice == MenuChoice.LANCER_PARTIE) {
                choice = MenuChoice.QUITTER;
        }else{
                choice = MenuChoice.LANCER_PARTIE;
        }
	}
	
    public void selectChoice() {
        if(choice == MenuChoice.LANCER_PARTIE)
			this.mygame.setGameScreen();
        if(choice == MenuChoice.QUITTER)
            Gdx.app.exit();
    }
}
