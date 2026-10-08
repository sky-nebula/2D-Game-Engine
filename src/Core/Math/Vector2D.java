package Core.Math;

public class Vector2D {
    public int X, Y;
    public static Vector2D ONE() {return new Vector2D(1, 1);}
    public static Vector2D ZERO() {return new Vector2D();}
    public Vector2D(){
        X = 0;
        Y = 0;
    }
    public Vector2D(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
    public void Add(Vector2D vector2D){
        Add(vector2D.X, vector2D.Y);
    }
    public void Add(int X, int Y){
        this.X += X;
        this.Y += Y;
    }
    public static Vector2D Add(Vector2D LHS, Vector2D RHS){
        Vector2D OUT = Vector2D.ZERO();
        OUT.X = LHS.X + RHS.X;
        OUT.Y = LHS.Y + RHS.Y;
        return OUT;
    }
    public void Scale(int Scalar){
        this.X *= Scalar;
        this.Y += Scalar;
    }
    public  static Vector2D Scale(Vector2D LHS, int Scalar){
        Vector2D OUT = Vector2D.ZERO();
        OUT.X = LHS.X * Scalar;
        OUT.Y = LHS.Y * Scalar;
        return OUT;
    }
}