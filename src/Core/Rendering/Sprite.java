package Core.Rendering;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Core.Math.*;

public class Sprite {

    BufferedImage IMAGE;
    public Vector2D POS;
    Vector2D SIZE;
    Vector2D OFFSET;
    String PATH;
    //Constructors
    public Sprite(){
        POS = new Vector2D();
        OFFSET = new Vector2D();
        PATH = "/Default.png";
        RefreshRaw();
    }
    public Sprite(String path){
        POS = new Vector2D();
        OFFSET = new Vector2D();
        PATH = path;
        RefreshRaw();
    }
    public Sprite(String path, Vector2D size, Vector2D offset) {
        POS = new Vector2D();
        SIZE = size;
        OFFSET = offset;
        PATH = path;
        Refresh();
    }
    public Sprite(BufferedImage image){
        POS = new Vector2D();
        OFFSET = new Vector2D();
        PATH = "";
        IMAGE = image;
        SIZE = new Vector2D(IMAGE.getWidth(), IMAGE.getHeight());
    }
    //Setters
    public void SetIMAGE(BufferedImage image){
        IMAGE = image;
    }
    public void SetSIZE(Vector2D size){
        SIZE = size;
    }
    public void SetOFFSET(Vector2D offset){
        OFFSET = offset;
    }
    public void SetPATH(String path){
        PATH = path;
    }
    //Getters
    public BufferedImage GetIMAGE(){
        return IMAGE;
    }
    public BufferedImage GetSubIMAGE(Vector2D size, Vector2D offset){
        return IMAGE.getSubimage(offset.X, offset.Y, size.X, size.Y);
    }
    public static BufferedImage LoadFromPath(String path){
        try {
            return ImageIO.read(Sprite.class.getResourceAsStream(path));
        }
        catch (IOException e){
            System.out.println("Sprite not found at: " + path);
        }
        return null;
    }
    //Mutator
    public void RefreshRaw(){
        IMAGE = LoadFromPath(PATH);
        if(IMAGE == null)
            IMAGE = LoadFromPath("/Default.png");
        else
            SIZE = new Vector2D(IMAGE.getWidth(), IMAGE.getHeight());
    }
    public void Refresh(){
        IMAGE = LoadFromPath(PATH);
        if(IMAGE==null)
            IMAGE = LoadFromPath("/Default.png");
        else
            IMAGE = GetSubIMAGE(SIZE, OFFSET);
    }
}
