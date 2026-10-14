import Plugins.Entity;
import Core.Rendering.*;
import Core.Engine.*;
import Core.Math.*;

import java.awt.event.KeyEvent;

void main() {
    Game game = new Game();

    long TimeBetweenUpdate = 1000000000/ Game.TargetUPS;
    long MaxDeltaTime = TimeBetweenUpdate * 10;
    long PreviousTime = 0;
    long CurrentTime = System.nanoTime();
    long DeltaTime = 0;

    game.Update();
    Entity entity = new Entity();
    entity.sprite = new Sprite("/2D-Game-Engine-Logo.png");
    UIButton button1 = new UIButton("/UIPanelB.png", "/UIPanelC.png", "/UIPanel.png", new Vector2D(72,24), new Vector2D());
    UIText text1 = new UIText("Button1", 20, new Vector2D(72, 24));
    UIButton button2 = new UIButton("/UIPanelB.png", "/UIPanelC.png", "/UIPanel.png", new Vector2D(72,24), new Vector2D());
    UIText text2 = new UIText("Button2", 20, new Vector2D(72, 24));
    UIButton[] buttons = new UIButton[]{button1, button2};
    UIMenu menu = new UIMenu(buttons);
    menu.POS.Y-=100;
    menu.POS.X = 50;
    button2.AddSubPanel(text2);
    button1.AddSubPanel(text1);
    button1.LISTENER.add(entity);
    game.AddToScene(entity);
    game.AddToUI(menu);
    TileMap map = new TileMap("/Stone Tileset.png", new Vector2D(16,16), new int[][]{{0,2,1},{9,2,10}});


    boolean run = true;
    while(run){
        if(DeltaTime > MaxDeltaTime){
            DeltaTime = MaxDeltaTime;
        }
        while(DeltaTime >= TimeBetweenUpdate){
            /*if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_D))
            object.GetPosition().X++;
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_A))
                object.GetPosition().X--;
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_W))
                object.GetPosition().Y++;
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_S))
                object.GetPosition().Y--;*/
            game.Update();
            DeltaTime -= TimeBetweenUpdate;
        }
        while(DeltaTime < TimeBetweenUpdate){
            Thread.yield();
            PreviousTime = CurrentTime;
            CurrentTime = System.nanoTime();
            DeltaTime += CurrentTime - PreviousTime;
        }
    }
}
