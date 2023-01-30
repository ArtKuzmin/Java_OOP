package Units;

import java.util.ArrayList;
import java.util.Deque;

public class Vector2 {
    float x, y;


    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Vector2 opposit) {
        return opposit.y == y && opposit.x == x;
    }

    public float getDistance(DefaultHero hero) {
        float dX = hero.position.x - this.x;
        float dY = hero.position.y - this.y;
        return (float) Math.sqrt(dX * dX + dY * dY);
    }
}