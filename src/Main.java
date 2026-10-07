import javax.swing.*;
import java.awt.*;

import Rendering.*;
import Engine.*;
import Math.*;

void main() {
    Game game = new Game();

    Sprite sprite = new Sprite("/2D-Game-Engine-Logo.png", new Vector(16, 16));
    Entity object = new Entity();
    object.sprite = sprite;
    Game.Objects.add(object);

    game.Update();

}
