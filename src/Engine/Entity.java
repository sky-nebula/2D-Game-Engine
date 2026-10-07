package Engine;
import Rendering.GamePanel;
import Rendering.Sprite;

public class Entity extends GameObject {
    public Sprite sprite;
    public Entity(){
    }
    public void Render(){
        sprite.POS = POS;
        GamePanel.SpriteLayer.add(sprite);
    }
}