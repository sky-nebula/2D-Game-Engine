package Engine;
import Math.Vector2D;
public class GameObject {
    Vector2D POS;
    public GameObject(){
        POS = new Vector2D();
    }
    public GameObject(Vector2D POS){
        this.POS = POS;
    }
    public GameObject(int X, int Y){
        POS = new Vector2D(X, Y);
    }
    public void SetPosition(int X, int Y){
        POS.X = X;
        POS.Y = Y;
    }
    public void SetPosition(Vector2D POS){
        this.POS = POS;
    }
    public Vector2D GetPosition(){
        return POS;
    }
    public void Render(){}
    public void OnCreate(){Game.gameObjects.add(this);}
    public void Update(){}
    public void OnDelete(){Game.gameObjects.remove(this);}
}