package Core.Rendering;

import Core.Engine.Game;
import Core.Math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UIPanel {
    Vector2D POS;
    Vector2D SIZE;
    Sprite BACKGROUND;
    UIPanel PARENT;
    ArrayList<UIPanel> SUBPANELS;
    boolean VISIBLE;

    public UIPanel() {
        SUBPANELS = new ArrayList<>();
        POS = new Vector2D();
        SIZE = new Vector2D();
    }
    public UIPanel(TileMap tilemap, Vector2D size) {
        SUBPANELS = new ArrayList<>();
        POS = new Vector2D();
        SIZE = size;
        BACKGROUND = new Sprite(GenerateIMAGE(tilemap, size));
    }
    public UIPanel(UIPanel parent) {
        PARENT = parent;
        parent.SUBPANELS.add(this);
        SUBPANELS = new ArrayList<>();
        POS = new Vector2D();
        SIZE = new Vector2D();
    }
    public UIPanel(UIPanel parent, TileMap tilemap, Vector2D size){
        PARENT = parent;
        parent.SUBPANELS.add(this);
        SUBPANELS = new ArrayList<>();
        POS = new Vector2D();
        SIZE = size;
        BACKGROUND = new Sprite(GenerateIMAGE(tilemap, size));
    }
    public void Render() {
        if (!VISIBLE)
            return;
        if (BACKGROUND != null)
            GamePanel.UILayer.add(BACKGROUND);
        for (UIPanel child : SUBPANELS) {
            child.Render();
        }
    }

    public static BufferedImage GenerateIMAGE(TileMap tilemap, Vector2D size){
        Vector2D tilesize = tilemap.GetTILESIZE();
        int horizontalSize = size.X/tilesize.X;
        int verticalSize = size.Y/tilesize.Y;
        int[][] imagemap = new int[verticalSize][horizontalSize];
        //012
        //345
        //678
        for(int i = 0; i < horizontalSize; i++){
            for(int j = 0; j < verticalSize; j++){
                imagemap[j][i] =4;
            }
        }
        for(int i = 0; i < horizontalSize; i++){
            imagemap[0][i] = 1;
            imagemap[verticalSize-1][i] = 7;
        }
        for(int i = 0; i < verticalSize; i++){
            imagemap[i][0] = 3;
            imagemap[i][horizontalSize-1] = 5;
        }
        imagemap[0][0]=0;
        imagemap[0][horizontalSize-1]=2;
        imagemap[verticalSize-1][0]=6;
        imagemap[verticalSize-1][horizontalSize-1]=8;
        return tilemap.GenerateMap(imagemap);
    }
}
