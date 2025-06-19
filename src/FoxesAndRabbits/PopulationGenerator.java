package FoxesAndRabbits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PopulationGenerator {
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;
    private static final double HEDGEHOG_CREATION_PROBABILITY = 0.04;
    private Field field;
    private List<Animal> animals;

    public Field GettingFields() {
    	return field;
    }
    public List<Animal> GettingAnimals() {
    	return animals;
    }
    
    public PopulationGenerator(int depth, int width) {
    	animals = new ArrayList<>();
    	field = new Field(depth, width);
    }
    
    private void populate()
    {
    	
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    animals.add(fox);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                }
                else if(rand.nextDouble() <= HEDGEHOG_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Hedgehog hedgehog = new Hedgehog(true, field, location);
                    animals.add(hedgehog);
                }
        
                // else leave the location empty.
            }
        }
    }
    public void reset()
    {
        animals.clear();
        populate();
        
        // Show the starting state in the view.

    }
}
