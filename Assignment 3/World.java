/**
 * Created by lael on 11/4/16.
 */

import java.util.concurrent.ThreadLocalRandom;
/**
 * This class will simulate the environment in which the animals and plants resided and interact
 */
public class World {

    public final int WORLD_MIN_SIZE = 5;
    private final int DEFAULT_MAX_SIZE = 10;
    public int duration = 0;
    public int world_Size;
    private int carnivores;
    private int herbivores;
    private int plants;
    private int empty_space;
    private int space_occupied;
    public Creature[][] worldGrid;
    public int time = 0;

    public World()
    {
        duration  = 5;
        world_Size = ThreadLocalRandom.current().nextInt(WORLD_MIN_SIZE,DEFAULT_MAX_SIZE);

        // initiate world
        worldGrid = new Creature[world_Size][world_Size];

        space_occupied = 0;
        space_occupied += herbivores = ThreadLocalRandom.current().nextInt(1,world_Size);
        space_occupied += carnivores = ThreadLocalRandom.current().nextInt(1,world_Size);
        space_occupied += plants = ThreadLocalRandom.current().nextInt(1,world_Size);
        empty_space = world_Size - space_occupied;
    }

    public World ( int duration, int world_Size, int carnivores, int herbivores, int plants)
    {
        if (carnivores + herbivores + plants > world_Size)
            throw new RuntimeException("Overpopulated world");

        this.duration = duration;
        this.world_Size = world_Size;
        this.carnivores = carnivores;
        this.herbivores = herbivores;
        this.plants = plants;
    }

    public void advance(int time)
    {
        for(int i = 0; i < time; i++)
            for(Creature[] creatureList : worldGrid)
                for(Creature c : creatureList)
                    c.advance();
    }

    public void advance()
    {
        for(Creature[] creatureList : worldGrid)
            for(Creature c : creatureList)
                c.advance();
    }

    public void display()
    {
        for (int i = 0; i < world_Size; i++) {
            for (int j = 0; j < world_Size; j++) {
                if (worldGrid[i][j] != null) {
                    System.out.print(worldGrid[i][j].getLook());
                    System.out.print(' ');
                }
                else
                    System.out.print(' ');
            }
            System.out.println();
        }

    }

    public void populate_world()
    {
        //null grids are empty spaces

        for (int i = 0; i < plants; )
        {
            int a = ThreadLocalRandom.current().nextInt(0,world_Size);
            int b = ThreadLocalRandom.current().nextInt(0,world_Size);
            if (worldGrid[a][b] == null) {
                worldGrid[a][b] = new Plant(this);
                worldGrid[a][b].location_x = a;
                worldGrid[a][b].location_y = b;
                i++;
            }
        }

        for (int i = 0; i < herbivores; )
        {
            int a = ThreadLocalRandom.current().nextInt(0,world_Size);
            int b = ThreadLocalRandom.current().nextInt(0,world_Size);
            if (worldGrid[a][b] == null) {
                worldGrid[a][b] = new Herbivore(this);
                worldGrid[a][b].location_x = a;
                worldGrid[a][b].location_y = b;
                i++;
            }
        }

        for (int i = 0; i < carnivores; ) {
            int a = ThreadLocalRandom.current().nextInt(0, world_Size);
            int b = ThreadLocalRandom.current().nextInt(0, world_Size);
            if (worldGrid[a][b] == null) {
                worldGrid[a][b] = new Carnivore(this);
                worldGrid[a][b].location_x = a;
                worldGrid[a][b].location_y = b;
                i++;
            }
        }
    }
}
