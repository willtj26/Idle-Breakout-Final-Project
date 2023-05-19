import java.awt.*;

public class ScatterBallBabies extends Balls {
    private int damage;
    public ScatterBallBabies() {
        super(5, 500, 500, Color.YELLOW, 3, 3);
        damage = 10;
    }
   
    public void collide(Brick r) {
        ScatterBallBabies l = new ScatterBallBabies();
        l = null;
        r.setBrickValue(r.getBrickValue() - damage);
        System.gc();
    }
}

