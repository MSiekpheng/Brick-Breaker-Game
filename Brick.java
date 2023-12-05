public class Brick extends GameObject {
    private boolean destroyed;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
        destroyed = false;
    }

    // Additional constructors for varying brick properties
    public Brick(int x, int y, int width, int height, boolean destroyed) {
        super(x, y, width, height);
        this.destroyed = destroyed;
    }

    // Getter and setter for destroyed property
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    // Other methods related to Brick...
}
