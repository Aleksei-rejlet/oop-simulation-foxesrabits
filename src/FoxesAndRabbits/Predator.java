package FoxesAndRabbits;

import java.util.Iterator;
import java.util.List;

public abstract class Predator extends Animal{
	protected static final int PREY_FOOD_VALUE = 3;
	public Predator(Field field, Location location) {
		super (field, location);
	}
}
