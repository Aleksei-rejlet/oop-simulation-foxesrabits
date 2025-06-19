package FoxesAndRabbits;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A simple predator-prey simulator, based on a rectangular field
 * containing rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;
    // A graphical view of the simulation.
    private int step;
    private PopulationGenerator generator;
    private SimulatorView view;
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
        view.setColor(Hedgehog.class, Color.RED);
        generator = new PopulationGenerator(depth, width);
        reset();
        // Setup a valid starting point.

    }
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(generator.GettingFields()); step++)
            simulateOneStep();
        }
    public void simulateOneStep()
    {
        step++;
        List<Animal> animals = generator.GettingAnimals();
        // Provide space for newborn animals.
        List<Animal> newAnimals = new ArrayList<Animal>();        
        // Let all rabbits act.
        for(Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if(! animal.isAlive()) {
                it.remove();
            }
        }
        animals.addAll(newAnimals);
        view.showStatus(step, generator.GettingFields());
        }
      
        
        public void reset()
        {
            step = 0;
            generator.reset();
            // Show the starting state in the view.
            Field field = generator.GettingFields();
            view.showStatus(step, field);

        }
        
}
