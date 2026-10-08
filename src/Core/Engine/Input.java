package Core.Engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class Input extends KeyAdapter {

    HashSet<Integer> KeyPress;
    HashSet<Integer> KeyHold;
    HashSet<Integer> KeyRelease;

    public Input() {
        KeyPress = new HashSet<>();
        KeyHold = new HashSet<>();
        KeyRelease = new HashSet<>();
    }
    public void keyPressed(KeyEvent e) {
        KeyPress.add(e.getKeyCode());
        KeyHold.add(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {
        KeyRelease.add(e.getKeyCode());
        KeyHold.remove(Integer.valueOf(e.getKeyCode()));
    }
    public void Clear(){
        KeyPress.clear();
        KeyRelease.clear();
    }
    public void ClearAll(){
        Clear();
        KeyHold.clear();
    }
    public boolean IsKeyPressed(int e){
        return KeyPress.contains(e);
    }
    public boolean IsKeyDown(int e){
        return KeyHold.contains(e);
    }
    public boolean IsKeyReleased(int e){
        return KeyRelease.contains(e);
    }
}