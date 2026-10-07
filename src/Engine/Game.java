package Engine;

import Rendering.RenderLayer;

import javax.swing.*;
import java.util.Vector;

public class Game {
    public static Vector<GameObject> gameObjects;
    public static RenderLayer TileMap;
    public static RenderLayer Sprites;
    public static RenderLayer UI;
    public static JFrame GameScreen;
    public static String title = "2D-Engine.Game-Engine";
    public static int ScreenWidth = 353;
    public static int ScreenHeight = 198;
    public static int ScreenScale = 2;
    public static int TargetFPS = 60;
    public static int TargetUPS = 60;
    public Game(){
        GameScreen = new JFrame(title);
        GameScreen.setSize(ScreenWidth*ScreenScale, ScreenHeight*ScreenScale);
        GameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameScreen.setVisible(true);
        TileMap = new RenderLayer();
        Sprites = new RenderLayer();
        UI = new RenderLayer();
        //GameScreen.add(TileMap);
        GameScreen.add(Sprites);
        //GameScreen.add(UI);
        gameObjects = new Vector<>();
    }
    public void Update(){
        //Process Input

        //Objects Update
        for(GameObject gameObject : gameObjects)
            gameObject.Update();
        for(GameObject gameObject : gameObjects)
            gameObject.Render();    //Pushes Sprites to the Stack
        //Render
        //TileMap.repaint();
        Sprites.repaint();
        //UI.repaint();

    }
}
