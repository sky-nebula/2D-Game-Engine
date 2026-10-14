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
    Sprite sprite = new Sprite("/2D-Game-Engine-Logo.png");
    UIPanel parent = new UIPanel(new Vector2D(25, -25));
    UIPanel child = new UIPanel("/UIPanel.png", new Vector2D(200,100), new Vector2D(0,-50));
    parent.AddSubPanel(child);
    game.AddToUI(parent);
    //UIPanel upanel = new UIPanel("/UIPanel.png", new Vector2D(3,3), new Vector2D(100,33));
    TileMap map = new TileMap("/Stone Tileset.png", new Vector2D(16,16), new int[][]{{0,2,1},{9,2,10}});
    entity.sprite = sprite;
    game.AddToScene(entity);
    //Game.gameObjects.add(map);
    //panel.AddSubPanel(upanel);
    //Game.gameObjects.add(panel);

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
