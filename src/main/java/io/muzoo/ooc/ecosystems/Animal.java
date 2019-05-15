package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Animal {

    // A shared random number generator to control breeding.
    protected static final Random rand = new Random();

    // The rabbit's age.
    private int age;
    // Whether the rabbit is alive or not.
    private boolean alive;
    // The rabbit's position
    private Location location;

    protected abstract int getMaxAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();
    protected abstract int getBreedingAge();

    public Animal(){
        age = 0;
        alive = true;
    }

    public abstract void act(Field currentField, Field updatedField, List newAnimal);

    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     *
     * @return The number of births (may be zero).
     */
//    int breed() {
//        int births = 0;
//        if (canBreed() && getRand().nextDouble() <= getBreedingProbability()) {
//            births = getRand().nextInt(getMaxLitterSize()) + 1;
//        }
//        return births;
//    }

    /**
     * A fox can breed if it has reached the breeding age.
     */
//    boolean canBreed() {
//        return age >= getBreedingAge();
//    }

    /**
     * Check whether the fox is alive or not.
     *
     * @return True if the fox is still alive.
     */
    protected boolean isAlive() {
        return alive;
    }

    protected void setDead(){
        alive = false;
    }

    /**
     * Set the animal's location.
     *
     * @param row The vertical coordinate of the location.
     * @param col The horizontal coordinate of the location.
     */
    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    /**
     * Set the rabbit's location.
     *
     * @param location The rabbit's location.
     */
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
}
