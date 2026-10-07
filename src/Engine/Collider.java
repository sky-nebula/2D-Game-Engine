package Engine;
import Math.*;
public class Collider extends GameObject {
    Vector2D RAD;
    public Collider(int X, int Y, int W, int H){
        POS = new Vector2D(X, Y);
        RAD = new Vector2D(W, H);
    }
    public Collider(Vector2D POS, Vector2D RAD){
        this.POS = POS;
        this.RAD = RAD;
    }
    void SetRadius(int W, int H){
        RAD.X = W;
        RAD.Y = H;
    }
    void SetRadius(Vector2D RAD){
        this.RAD = RAD;
    }
    Vector2D GetRadius(){
        return RAD;
    }
    boolean IsColliding(Collider collider){
        return collider.POS.X - collider.RAD.X <  POS.X + RAD.X &&
                collider.POS.X + collider.RAD.X >  POS.X - RAD.X &&
                collider.POS.Y - collider.RAD.Y <  POS.Y + RAD.Y &&
                collider.POS.Y + collider.RAD.Y >  POS.Y - RAD.Y;
    }
}