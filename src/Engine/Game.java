package Engine;

import Rendering.GameScreen;

import java.awt.event.KeyEvent;
import java.util.Vector;

public class Game {
    public static Vector<GameObject> gameObjects;
    public static GameScreen Screen;
    public static int TargetFPS = 60;
    public static int TargetUPS = 60;
    public Game(){
        Screen = new GameScreen();
        gameObjects = new Vector<>();
    }
    public void Update(){
        Screen.Clear();
        //Process Input

        //Objects Update
        for(GameObject gameObject : gameObjects)
            gameObject.Update();
        for(GameObject gameObject : gameObjects)
            gameObject.Render();    //Pushes Sprites to the Stack
        //Render
        //TileMap.repaint();
        Screen.DrawScreen();
        //UI.repaint();
        Screen.INPUT.Clear();

    }
}
