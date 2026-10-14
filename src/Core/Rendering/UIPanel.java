package Core.Rendering;

import Core.Engine.MapGen;
import Core.Engine.Renderable;
import Core.Math.Vector2D;

import java.util.ArrayList;

public class UIPanel implements Renderable {
    Vector2D POS;
    Vector2D SIZE;
    TileMap BACKGROUND;
    UIPanel PARENT;
    ArrayList<UIPanel> SUBPANELS;
    boolean VISIBLE = true;

    public UIPanel() {
        SUBPANELS = new ArrayList<>();
        POS = new Vector2D();
        SIZE = new Vector2D();
    }
    public UIPanel(Vector2D pos){
        SUBPANELS = new ArrayList<>();
        POS = pos;
        SIZE = new Vector2D();
    }
    public UIPanel(String path, Vector2D size, Vector2D pos) {
        SUBPANELS = new ArrayList<>();
        POS = pos;
        SIZE = size;
        Sprite sprite = new Sprite(path);
        Vector2D tilesize = new Vector2D(sprite.SIZE.X/3, sprite.SIZE.Y/3);
        Vector2D tilemapsize =  new Vector2D(size.X/ tilesize.X, size.Y/ tilesize.Y);
        BACKGROUND = new TileMap(sprite, tilesize, MapGen.NineSlicedMap(tilemapsize));
    }
    @Override
    public void Render(){
        if(!VISIBLE) return;
        if(BACKGROUND != null){
            BACKGROUND.SPRITE.POS = GetGlobalPosition();
            GamePanel.UILayer.add(BACKGROUND.GetSPRITE());
        }
        for(UIPanel panel : SUBPANELS)
            panel.Render();
    }
    public Vector2D GetGlobalPosition(){
        if(PARENT == null)
            return POS;
        return Vector2D.Add(POS, PARENT.GetGlobalPosition());
    }
    public void AddSubPanel(UIPanel subpanel){
        SUBPANELS.add(subpanel);
        subpanel.PARENT = this;
    }
}
