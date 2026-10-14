package Core.Rendering;

import Core.Engine.Game;
import Core.Engine.Input;
import Core.Engine.MapGen;
import Core.Engine.Updateable;
import Core.Math.Vector2D;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UIButton extends UIPanel implements Updateable {
    public boolean ACTIVE;
    public boolean BRIGHTEN;
    public boolean DARKEN;
    public TileMap HIGHLIGHT;
    public TileMap LOWLIGHT;
    public ArrayList<UIButtonListener> LISTENER;
    public UIButton(String pathhighlight, String pathlowlight, String pathbackground, Vector2D size, Vector2D pos){
        super(pathbackground, size, pos);
        LISTENER = new ArrayList<>();
        Sprite sprite = new Sprite(pathhighlight);
        Vector2D tilesize = new Vector2D(sprite.SIZE.X/3, sprite.SIZE.Y/3);
        Vector2D tilemapsize =  new Vector2D(size.X/ tilesize.X, size.Y/ tilesize.Y);
        HIGHLIGHT = new TileMap(sprite, tilesize, MapGen.NineSlicedMap(tilemapsize));
        sprite = new Sprite(pathlowlight);
        tilesize = new Vector2D(sprite.SIZE.X/3, sprite.SIZE.Y/3);
        tilemapsize =  new Vector2D(size.X/ tilesize.X, size.Y/ tilesize.Y);
        LOWLIGHT = new TileMap(sprite, tilesize, MapGen.NineSlicedMap(tilemapsize));
    }
    public void Update(){
        if(!ACTIVE) return;
        if(GameScreen.INPUT.IsKeyReleased(KeyEvent.VK_ENTER)){
            DARKEN = false;
            BRIGHTEN = false;
            for(UIButtonListener listener : LISTENER)
                listener.OnPress();
        }
        else if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_ENTER)){
            System.out.println("button held");
            DARKEN = true;
            BRIGHTEN = false;
        }
        else{
            DARKEN = false;
            BRIGHTEN = true;
        }
    }
    public void SetActive(boolean active){
        ACTIVE = active;
        if(!ACTIVE){
            DARKEN = false;
            BRIGHTEN = false;
        }
    }

    @Override
    public void Render() {
        if(!VISIBLE) return;
        if(DARKEN){
            LOWLIGHT.SPRITE.POS = GetGlobalPosition();
            GamePanel.UILayer.add(LOWLIGHT.GetSPRITE());
        }
        else if(BRIGHTEN){
            HIGHLIGHT.SPRITE.POS = GetGlobalPosition();
            GamePanel.UILayer.add(HIGHLIGHT.GetSPRITE());
        }
        else{
            BACKGROUND.SPRITE.POS = GetGlobalPosition();
            GamePanel.UILayer.add(BACKGROUND.GetSPRITE());
        }
        for(UIPanel panel : SUBPANELS)
            panel.Render();
    }
}
