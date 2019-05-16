package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Animal {

    // A shared random number generator to control breeding.
    protected static final Random rand = new Random();

    // An animal's age.
    private int age;
    // Whether the animal is alive or not.
    private boolean alive;
    // An animal's position
    private Location location;
    // The animal's food level, which is increased by eating other animals.
    private int foodLevel;

    protected abstract int getMaxAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();
    protected abstract int getBreedingAge();

    public Animal(){
        age = 0;
        alive = true;
    }

    public abstract void act(Field currentField, Field updatedField, List newAnimal);

    protected abstract Location findFood(Field field, Location location);

    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    protected void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    int breed() {
        int births = 0;
        if (canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    boolean canBreed() {
        return age >= getBreedingAge();
    }

    protected boolean isAlive() {
        return alive;
    }

    protected void setDead(){
        alive = false;
    }

    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    protected int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }
}
