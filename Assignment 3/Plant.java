/**
 * Created by lael on 11/6/16.
 */
public class Plant extends Creature{
//    public int energy = 5; // amount of energy this creature starts out with
      public char look = '*'; // how this creature looks in the world
      private World world;
      public String type = "Plant";
//    public int location_x;
//    public int location_y;


    Plant(World world)
    {
        this.world = world;
    }

    void advance() {
        // does nothing
    }

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
