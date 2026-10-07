package Rendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Math.*;

public class Sprite {
    BufferedImage SPRITE;
    public Vector2D POS;
    Vector2D INDEX;
    Vector2D SIZE;
    public Sprite(String PATH, int SIZE, Vector2D INDEX) {
        POS = new Vector2D();
        this.SIZE = Vector2D.Scale(Vector2D.ONE(), SIZE);
        this.INDEX = Vector2D.Scale(INDEX, SIZE);

        try {
            SPRITE = ImageIO.read(getClass().getResourceAsStream(PATH));
        }
        catch (IOException e){
            System.out.println("Sprite not found at: " + PATH);
        }
        SPRITE = SPRITE.getSubimage(this.INDEX.X, this.INDEX.Y, this.SIZE.X, this.SIZE.Y);
    }
    public Sprite(String PATH){
        this(PATH, 16, Vector2D.ZERO());
    }
    public BufferedImage GetSprite(){
        return SPRITE;
    }
}
