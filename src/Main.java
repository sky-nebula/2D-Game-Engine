import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    JFrame frame = new JFrame("2D-Game-Engine");
    JLabel label = new JLabel("");
    frame.add(label);
    frame.setSize(300, 200);


    frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
}
