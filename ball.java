public class ball {
    private int width;
    private int height;
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXspeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYspeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void move() {

    }

    public void bounce() {

    }

    public boolean outOfBounds() {
        return false;
    }
}
