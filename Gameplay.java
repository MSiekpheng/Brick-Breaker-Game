import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements KeyListener {
    private Paddle paddle;

    public Gameplay() {
        paddle = new Paddle(300, 480, 100, 8, 5);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the paddle
        g.setColor(Color.GREEN);
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e, getWidth());
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Implement the keyReleased method as required by the KeyListener interface
        // This method can be left empty if you don't need any functionality on key
        // release
    }

    // Main method for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gameplay gameplay = new Gameplay();
        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("Brick Breaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
    }
}
