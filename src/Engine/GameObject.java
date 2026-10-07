package Engine;
import Math.Vector;
public class GameObject {
    Vector POS;
    public GameObject(){
        POS = new Vector();
    }
    public GameObject(Vector POS){
        this.POS = POS;
    }
    public GameObject(int X, int Y){
        POS = new Vector(X, Y);
    }
    public void SetPosition(int X, int Y){
        POS.X = X;
        POS.Y = Y;
    }
    public void SetPosition(Vector POS){
        this.POS = POS;
    }
    public Vector GetPosition(){
        return POS;
    }
    public void Render(){}
    public void OnCreate(){Game.gameObjects.add(this);}
    public void Update(){}
    public void OnDelete(){Game.gameObjects.remove(this);}
}