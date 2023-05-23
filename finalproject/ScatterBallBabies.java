import java.awt.*;

public class ScatterBallBabies extends Balls {
    private int damage;
    public ScatterBallBabies() {
        super(5, 500, 500, Color.YELLOW, 3, 3);
        damage = 10;
    }
   
    public void collide(Brick r) {
        r.setBrickValue(r.getBrickValue() - damage);
    }
    public void increaseDamage() {
        damage += 1;
     }
     public int getDamage() {
        return damage;
     }
     public int getSpeed() {
        return getdX();
     }
}

