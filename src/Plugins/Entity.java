package Plugins;
import Core.Engine.GameObject;
import Core.Rendering.GamePanel;
import Core.Rendering.Sprite;
import Core.Rendering.UIButtonListener;

public class Entity extends GameObject implements UIButtonListener {
    public Sprite sprite;
    public Entity(){
        sprite = new Sprite();
    }
    public void Render(){
        sprite.POS = POS;
        GamePanel.SpriteLayer.add(sprite);
    }

    @Override
    public void OnPress() {
        POS.X+=10;
    }
}