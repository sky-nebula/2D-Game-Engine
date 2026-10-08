package Core.Rendering;
import Core.Engine.GameObject;
import Core.Math.*;
public class Camera {
    public Vector2D POS;
    boolean Follow;
    GameObject Target;
    public Camera(){
        POS = new Vector2D();
    }
}
