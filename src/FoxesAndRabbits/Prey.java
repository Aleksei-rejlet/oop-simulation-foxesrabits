package FoxesAndRabbits;

public abstract class Prey extends Animal{

	final int foodlevel;
	public Prey(Field field, Location location, int foodlevel) {
		super(field, location);
		this.foodlevel = foodlevel;
	}
	protected int getFoodLevel() {
		return this.foodlevel;
	}
}
