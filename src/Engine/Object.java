package Engine;
import Math.Vector;
public class Object{
    Vector POS;
    public Object(){
        POS = new Vector();
    }
    public Object(Vector POS){
        this.POS = POS;
    }
    public Object(int X, int Y){
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
    public void OnCreate(){}
    public void Update(){}
    public void OnDelete(){}
}