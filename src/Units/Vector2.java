package Units;

public class Vector2 {
    int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Vector2 opposit) {
        return opposit.y == y && opposit.x == x;
    }
}