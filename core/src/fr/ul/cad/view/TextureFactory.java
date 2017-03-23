package fr.ul.cad.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureFactory {
    private static TextureFactory instance = new TextureFactory();
    private TextureRegion menuBackground,menuBoutonLancer,menuBoutonLancerSelect,menuBoutonQuitter,menuBoutonQuitterSelect;
    
    private TextureFactory() {
        menuBackground = new TextureRegion(new Texture(Gdx.files.internal("images/background.jpg")));
        menuBoutonLancer = new TextureRegion(new Texture(Gdx.files.internal("images/lancer.png")));
        menuBoutonLancerSelect = new TextureRegion(new Texture(Gdx.files.internal("images/lancerSelect.png")));
        menuBoutonQuitter = new TextureRegion(new Texture(Gdx.files.internal("images/quitter.png")));
        menuBoutonQuitterSelect = new TextureRegion(new Texture(Gdx.files.internal("images/quitterSelect.png")));
    }

    public static TextureFactory getInstance() {
        return instance;
    }
    
    public TextureRegion getMenuBackground() { return menuBackground; }
    public TextureRegion getMenuBoutonLancer() { return menuBoutonLancer; }
    public TextureRegion getMenuBoutonLancerSelect() { return menuBoutonLancerSelect; }
    public TextureRegion getMenuBoutonQuitter() { return menuBoutonQuitter; }
    public TextureRegion getMenuBoutonQuitterSelect() { return menuBoutonQuitterSelect; }

}
