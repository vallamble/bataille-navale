package fr.ul.cad.view;


public class TextureFactory {
    private static TextureFactory instance = new TextureFactory();
    
    private TextureFactory() {
      
    }

    public static TextureFactory getInstance() {
        return instance;
    }
    
   
}
