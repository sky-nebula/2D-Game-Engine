package Core.Rendering;

import Core.Engine.Game;
import Core.Engine.Input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UIButton extends UIPanel{
    public boolean ACTIVE;
    public ArrayList<UIButtonListener> LISTENER;
    public void Update(){
        if(GameScreen.INPUT.IsKeyPressed(KeyEvent.VK_ENTER)){
            for(UIButtonListener listener : LISTENER)
                listener.OnPress();
        }
    }
}
