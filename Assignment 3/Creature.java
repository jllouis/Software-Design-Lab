/**
 * Created by lael on 11/5/16.
 */
public abstract class Creature {
    private final int MIN_BIRTH_ENERGY = 5; // need at least this amount of energy to give birth
    private final int MAX_EAT_ENERGY = 9;  // will not eat if have this amount of energy or more
    public int energy; // amount of energy this creature starts out with
    public char look; // how this creature looks in the world
    public String type;
    public int location_x;
    public int location_y;
    private int lifespan; // lives for up to 10 ticks
    private int speed; // allowed to move once every two clocks.
    private int birth_time; // time of the world when this creature was born
    private World world;
    private int lastmoved;

    abstract void advance();
    abstract void setLocation(int a, int b);
    abstract char getLook();

}
