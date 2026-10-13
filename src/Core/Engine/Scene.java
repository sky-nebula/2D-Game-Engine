package Core.Engine;

import Core.Math.Vector2D;

import java.util.ArrayList;

public class Scene {
    public ArrayList<GameObject> gameObjects;
    public Scene(){gameObjects = new ArrayList<>();}
    public void Create(String object, Vector2D POS){
        Class<?> GameObjectClass = object.getClass();

    }
}
