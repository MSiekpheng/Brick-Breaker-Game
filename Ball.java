public class Ball extends GameObject {
    private int speedX, speedY;

    public Ball(int x, int y, int width, int height, int speedX, int speedY) {
        super(x, y, width, height);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    // Additional constructor for a default ball
    public Ball(int x, int y) {
        super(x, y, 10, 10); // Default width and height
        this.speedX = 2; // Default X speed
        this.speedY = -2; // Default Y speed
    }

    // Getter and setter for speedX and speedY
    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    // Other methods related to Ball...
}
