package Engine;
import Rendering.Sprite;

public class Entity extends GameObject {
    public Sprite sprite;
    public Entity(){
    }
    public void Render(){
        sprite.POS = POS;
        Game.Sprites.sprites.push(sprite);
    }
}