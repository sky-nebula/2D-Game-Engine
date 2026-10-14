package Core.Engine;

import Core.Rendering.GamePanel;
import Core.Rendering.GameScreen;
import Core.Rendering.Sprite;
import Core.Rendering.UIPanel;

import java.util.ArrayList;


public class Game {
    public ArrayList<GameObject> gameObjects;
    public ArrayList<UIPanel> uiPanels;
    public GameScreen Screen;
    public static int TargetUPS = 60;
    public Game(){
        Screen = new GameScreen();
        gameObjects = new ArrayList<>();
        uiPanels = new ArrayList<>();
    }
    public void Update(){
        //Clear Screen Buffer
        Screen.Clear();
        //Objects Update
        for(GameObject gameObject : gameObjects){
            if(gameObject instanceof Updateable updateable){
                updateable.Update();
            }
        }
        for(GameObject gameObject : gameObjects){
            if(gameObject instanceof Renderable renderable){
                renderable.Render();
            }
        }
        //UI Update
        for(UIPanel uiPanel : uiPanels){
            if(uiPanel instanceof Updateable updateable){
                updateable.Update();
            }
        }
        for(UIPanel uiPanel : uiPanels){
            if(uiPanel instanceof Renderable renderable){
                renderable.Render();
            }
        }
        //Render Screen
        Screen.DrawScreen();
        //Clear Input OnPress/OnRelease
        GameScreen.INPUT.Clear();
    }
    public void AddToScene(GameObject gameObject){
        gameObjects.add(gameObject);
        gameObject.OnCreate();
    }
    public void RemoveFromScene(GameObject gameObject){
        gameObject.OnDelete();
        gameObjects.remove(gameObject);
    }
    public void AddToUI(UIPanel uiPanel){
        uiPanels.add(uiPanel);
    }
    public void RemoveFromUI(UIPanel uiPanel){
        uiPanels.remove(uiPanel);
    }
}
