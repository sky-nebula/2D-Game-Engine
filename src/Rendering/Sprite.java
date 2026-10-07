package Rendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Math.*;
import Engine.*;
public class Sprite extends JPanel{
    public BufferedImage sprite;
    public Vector POS;
    public Vector SIZE;
    public Sprite(String path, Vector SIZE) {
        POS = new Vector();
        this.SIZE = SIZE;
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream(path));
        }
        catch (IOException e){
            System.out.println("Sprite not found at: " + path);
        }
    }

}
