package Core.Rendering;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public static ArrayList<Sprite> TileMapLayer;
    public static ArrayList<Sprite> SpriteLayer;
    public static ArrayList<Sprite> UILayer;
    public GamePanel(){
        TileMapLayer = new ArrayList<>();
        SpriteLayer = new ArrayList<>();
        UILayer = new ArrayList<>();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);               // always call this
        Graphics2D g2 = (Graphics2D) g;        // upgrade to Graphics2D
        paintLayer(g2, TileMapLayer);
        paintLayer(g2, SpriteLayer);
        paintLayer(g2, UILayer);

    }
    public void Clear(){
        TileMapLayer.clear();
        SpriteLayer.clear();
        UILayer.clear();
    }
    void paintLayer(Graphics2D g2, ArrayList<Sprite> layer){
        for(Sprite sprite : layer){
            g2.drawImage(sprite.SPRITE, sprite.POS.X*GameScreen.ScreenScale,
                    -sprite.POS.Y*GameScreen.ScreenScale,
                    sprite.SIZE.X*GameScreen.ScreenScale,
                    sprite.SIZE.Y*GameScreen.ScreenScale,
                    null);
        }
    }
}
