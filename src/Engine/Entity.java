package Engine;
import Rendering.Sprite;

public class Entity extends Object {
    public Sprite sprite;
    public Entity(){
    }
    public void Render(){
        Game.Sprites.sprites.push(sprite);
    }
}