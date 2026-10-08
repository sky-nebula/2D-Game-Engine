import Rendering.*;
import Engine.*;
import Math.*;

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
    entity.sprite = sprite;
    Game.gameObjects.add(entity);
    boolean run = true;
    while(run){
        if(DeltaTime > MaxDeltaTime){
            DeltaTime = MaxDeltaTime;
        }
        while(DeltaTime >= TimeBetweenUpdate){
            GameObject object = Game.gameObjects.get(0);
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_D))
            object.GetPosition().X++;
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_A))
                object.GetPosition().X--;
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_W))
                object.GetPosition().Y++;
            if(GameScreen.INPUT.IsKeyDown(KeyEvent.VK_S))
                object.GetPosition().Y--;
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
