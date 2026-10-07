package Rendering;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.Vector;
import Engine.*;
public class RenderLayer extends JPanel {
    public RenderLayer(){sprites = new Stack<>();}
    public Stack<Sprite> sprites;
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);               // always call this
        Graphics2D g2 = (Graphics2D) g;        // upgrade to Graphics2D
        while(!sprites.empty()){
            Sprite sprite = sprites.pop();
            g2.drawImage(sprite.SPRITE, sprite.POS.X*Game.ScreenScale,
                    sprite.POS.Y*Game.ScreenScale,
                    sprite.SIZE.X*Game.ScreenScale,
                    sprite.SIZE.Y*Game.ScreenScale,
                    null);
        }
    }
}
