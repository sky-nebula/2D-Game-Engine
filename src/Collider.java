public class Collider extends Object{
    Vector RAD;
    public Collider(int X, int Y, int W, int H){
        POS = new Vector(X, Y);
        RAD = new Vector(W, H);
    }
    public Collider(Vector POS, Vector RAD){
        this.POS = POS;
        this.RAD = RAD;
    }
    void SetRadius(int W, int H){
        RAD.X = W;
        RAD.Y = H;
    }
    void SetRadius(Vector RAD){
        this.RAD =RAD;
    }
    Vector GetRadius(){
        return RAD;
    }
    boolean IsColliding(Collider collider){
        return collider.POS.X - collider.RAD.X <  POS.X + RAD.X &&
                collider.POS.X + collider.RAD.X >  POS.X - RAD.X &&
                collider.POS.Y - collider.RAD.Y <  POS.Y + RAD.Y &&
                collider.POS.Y + collider.RAD.Y >  POS.Y - RAD.Y;
    }
}