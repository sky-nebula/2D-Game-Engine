package Core.Rendering;

import Core.Math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIText extends UIPanel{
    Sprite SPRITE;
    public UIText(String text, int fontsize, Vector2D size){
        super();
        BufferedImage bufferedImage = new BufferedImage(size.X, size.Y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.setFont(new Font("Arial", Font.PLAIN, fontsize));
        g2.setColor(new Color(0,0,0));
        g2.drawString(text, 0, size.Y);
        g2.dispose();
        SPRITE = new Sprite(bufferedImage);
    }
    @Override
    public void Render(){
        if(!VISIBLE) return;
        if(SPRITE != null){
            SPRITE.POS = GetGlobalPosition();
            GamePanel.UILayer.add(SPRITE);
        }
        for(UIPanel panel : SUBPANELS)
            panel.Render();
    }
}
