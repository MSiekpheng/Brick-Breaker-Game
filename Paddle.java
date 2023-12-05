import java.awt.event.KeyEvent;

public class Paddle extends GameObject {
    private int speed;

    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Move the paddle left
    public void moveLeft() {
        if (getX() > 0) {
            setX(getX() - speed);
        }
    }

    // Move the paddle right
    public void moveRight(int frameWidth) {
        if (getX() + getWidth() < frameWidth) {
            setX(getX() + speed);
        }
    }

    // Handle paddle movement based on key input
    public void keyPressed(KeyEvent e, int frameWidth) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            moveLeft();
        } else if (key == KeyEvent.VK_RIGHT) {
            moveRight(frameWidth);
        }
    }
}
