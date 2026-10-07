import Rendering.*;
import Engine.*;
import Math.*;

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
            object.GetPosition().Add(1,0);
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
