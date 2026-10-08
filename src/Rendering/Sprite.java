package Rendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Math.*;

public class Sprite {
    BufferedImage SPRITE;
    public Vector2D POS;
    public Vector2D SIZE;
    public Sprite(String PATH){
        POS = new Vector2D();
        SIZE = new Vector2D();
        SPRITE = LoadSprite(PATH);
        if(SPRITE==null) return;
        SIZE.X = SPRITE.getWidth();
        SIZE.Y = SPRITE.getHeight();
    }
    public Sprite(String PATH, Vector2D SIZE, Vector2D OFFSET) {
        this(PATH);
        SPRITE = SPRITE.getSubimage(OFFSET.X, OFFSET.Y, SIZE.X, SIZE.Y);
    }
    public Sprite(BufferedImage SPRITE){
        POS = new Vector2D();
        this.SPRITE = SPRITE;
        SIZE = new Vector2D();
        SIZE.X = SPRITE.getWidth();
        SIZE.Y = SPRITE.getHeight();
    }

    public BufferedImage GetSprite(){
        return SPRITE;
    }
    public BufferedImage GetSubSprite(Vector2D SIZE, Vector2D OFFSET){
        return SPRITE.getSubimage(OFFSET.X, OFFSET.Y, SIZE.X, SIZE.Y);
    }
    public void SetSprite(BufferedImage SPRITE){
        this.SPRITE = SPRITE;
    }
    public static BufferedImage LoadSprite(String PATH){
        try {
             return ImageIO.read(Sprite.class.getResourceAsStream(PATH));
        }
        catch (IOException e){
            System.out.println("Sprite not found at: " + PATH);
        }
        return null;
    }
}
