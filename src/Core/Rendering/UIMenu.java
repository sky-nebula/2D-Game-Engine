package Core.Rendering;

import Core.Engine.Updateable;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UIMenu extends UIPanel implements Updateable {
    UIButton[] BUTTONS;
    int index = 0;
    int verticalSize;
    public UIMenu(UIButton[] buttons){
        super();
        BUTTONS = buttons;
        verticalSize = 0;
        for(UIButton button : BUTTONS){
            button.POS.Y -= verticalSize;
            verticalSize += button.SIZE.Y;
            AddSubPanel(button);
        }
    }

    @Override
    public void Update() {
        for(UIButton button : BUTTONS){
            button.Update();
        }
        if(GameScreen.INPUT.IsKeyPressed(KeyEvent.VK_W)){
            BUTTONS[index].SetActive(false);
            index++;
            if(index >= BUTTONS.length) index = 0;
            BUTTONS[index].SetActive(true);
            System.out.println("MenuUp");
        }
        if(GameScreen.INPUT.IsKeyPressed(KeyEvent.VK_S)){
            BUTTONS[index].SetActive(false);
            index--;
            if(index < 0) index = BUTTONS.length-1;
            BUTTONS[index].SetActive(true);
        }
    }
}
