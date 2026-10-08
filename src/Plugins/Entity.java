package Plugins;
import Core.Engine.GameObject;
import Core.Rendering.GamePanel;
import Core.Rendering.Sprite;

public class Entity extends GameObject {
    public Sprite sprite;
    public Entity(){
    }
    public void Render(){
        sprite.POS = POS;
        GamePanel.SpriteLayer.add(sprite);
    }
}