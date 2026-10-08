package Rendering;

import Engine.Input;

import javax.swing.*;

public class GameScreen {
    public JFrame Frame;
    public static String title = "2D-Game-Engine";
    public static int ScreenWidth = 352;
    public static int ScreenHeight = 198;
    public static int ScreenScale = 2;
    public static GamePanel Panel;
    public static Input INPUT;
    public GameScreen(){
        Frame = new JFrame(title);
        Frame.setSize(ScreenWidth*ScreenScale, ScreenHeight*ScreenScale);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        Panel = new GamePanel();
        Frame.add(Panel);
        INPUT = new Input();
        Frame.addKeyListener(INPUT);
    }
    public void DrawScreen(){
        Panel.repaint();
    }
    public void Clear(){
        Panel.Clear();
    }

}
