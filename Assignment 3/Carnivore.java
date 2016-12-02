/**
 * Created by laël on 11/5/16.
 */

import java.util.concurrent.ThreadLocalRandom;

public class Carnivore extends Creature {

    private final int MIN_BIRTH_ENERGY = 5; // need at least this amount of energy to give birth
    private final int MAX_EAT_ENERGY = 9;  // will not eat if have this amount of energy or more
    public int energy = 3; // amount of energy this creature starts out with
    public char look = '@'; // how this creature looks in the world
    public String type = "Carnivore";
    public int location_x;
    public int location_y;
    private int lifespan = 10; // lives for up to 10 ticks
    private int speed = 1; // allowed to move once every two clocks.
    private int birth_time; // time of the world when this creature was born
    private World world;
    private int lastmoved;

    /**
     * Constructor - initializes this creature in its world
     * @param world the world which this creature shall exist in
     */
    Carnivore(World world) {
        this.world = world;
        birth_time = world.time;
        lastmoved = 0;
    }

    /**
     * performs creature's allowed life functions if time and speed allows
     */
    public void advance() {
        if(lastmoved % speed == 0) // enforcing move at specified creature speed
            move(location_x + ThreadLocalRandom.current().nextInt(-1, 2), location_y + ThreadLocalRandom.current().nextInt(-1, 2));

        lifespan--;
        energy--;

        // attempting to give birth if there is free space around this creature
        if (energy > MIN_BIRTH_ENERGY) {
            boolean gaveBirth = false;
            int attempts = 0;
            while (!gaveBirth && attempts < 4)
                gaveBirth = giveBirth();
                attempts++;
        }

        if (world.time - birth_time >= lifespan) // die
            world.worldGrid[location_x][location_y] = null;

    }

    /**
     * attempts to give birth, if there's available space around the creature
     * @return boolean of whether birthing was successful
     */
    private boolean giveBirth()
    {
        int r1 = ThreadLocalRandom.current().nextInt(-1, 2), r2 = ThreadLocalRandom.current().nextInt(-1, 2);

        if (world.worldGrid[location_x + r1][location_y + r2] == null) {
            world.worldGrid[location_x + r1][location_y + r2] = new Carnivore(world);
            return true;
        }
        else
            return false;
    }

    /**
     * moves creature to adjacent grid - if there's space
     * @param a
     * @param b
     */
    private void move(int a, int b) {

        if ((a < 0 || a > world.world_Size - 1) || (b < 0 || b > world.world_Size - 1))
            return; // don't move

        else if (world.worldGrid[a][b].type == "Herbivore") {
            if (energy > MAX_EAT_ENERGY)
                return;

            energy += world.worldGrid[a][b].energy;
            world.worldGrid[a][b] = this;
            setLocation(a, b);
            lastmoved = world.time;

        } else if (world.worldGrid[a][b] == null) {
            setLocation(a, b);
            lastmoved = world.time;
        }
    }

    /**
     * sets location for this creature
     * @param a x location
     * @param b y location
     */
    public void setLocation(int a, int b) {
        location_x = a;
        location_y = b;
    }

    /**
     *
     * @return returns the look of the creature
     */
    public char getLook()
    {
        return look;
    }
}
