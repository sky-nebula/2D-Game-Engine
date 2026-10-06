public class Vector {
    public int X, Y;
    Vector(){
        X = 0;
        Y = 0;
    }
    Vector(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
    public void Add(Vector vector){
        Add(vector.X, vector.Y);
    }
    public void Add(int X, int Y){
        this.X += X;
        this.Y += Y;
    }
    public Vector AddCopy(Vector vector){
        return AddCopy(vector.X, vector.Y);
    }
    public Vector AddCopy(int X, int Y){
        return new Vector(this.X + X, this .Y + Y);
    }
}