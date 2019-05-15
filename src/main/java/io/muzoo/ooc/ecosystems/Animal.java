package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Animal {

    // The age at which a fox can start to breed.
    private static int BREEDING_AGE;
    // The age to which a fox can live.
    private static int MAX_AGE;
    // The likelihood of a fox breeding.
    private static double BREEDING_PROBABILITY;
    // The maximum number of births.
    private static int MAX_LITTER_SIZE;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static int FOOD_VALUE;
    // A shared random number generator to control breeding.
    private static final Random rand = new Random();

    // The rabbit's age.
    private int age;
    // Whether the rabbit is alive or not.
    private boolean alive;
    // The rabbit's position
    private Location location;
    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    public static int getBreedingAge() {
        return BREEDING_AGE;
    }

    public static int getMaxAge() {
        return MAX_AGE;
    }

    public static double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }

    public static int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }

    public static int getFoodValue() {
        return FOOD_VALUE;
    }

    public static Random getRand() {
        return rand;
    }

    public int getAge() {
        return age;
    }

    public Location getLocation() {
        return location;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public boolean getAlive(){ return alive; }

    public static void setBreedingAge(int breedingAge) {
        BREEDING_AGE = breedingAge;
    }

    public static void setMaxAge(int maxAge) {
        MAX_AGE = maxAge;
    }

    public static void setBreedingProbability(double breedingProbability) {
        BREEDING_PROBABILITY = breedingProbability;
    }

    public static void setMaxLitterSize(int maxLitterSize) {
        MAX_LITTER_SIZE = maxLitterSize;
    }

    public static void setFoodValue(int foodValue) {
        FOOD_VALUE = foodValue;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Animal(){

    }

    public Animal(boolean randomAge){
        setAge(0);
        setAlive(true);
        if (randomAge) {
            setAge(getRand().nextInt(MAX_AGE));
        }
    }

//    void incrementAge() {
//        age++;
//        if (age > MAX_AGE) {
//            alive = false;
//        }
//    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
//    void incrementHunger() {
//        foodLevel--;
//        if (foodLevel <= 0) {
//            alive = false;
//        }
//    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     *
     * @return The number of births (may be zero).
     */
//    int breed() {
//        int births = 0;
//        if (canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
//            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
//        }
//        return births;
//    }

    /**
     * A fox can breed if it has reached the breeding age.
     */
//    boolean canBreed() {
//        return age >= BREEDING_AGE;
//    }

    /**
     * Check whether the fox is alive or not.
     *
     * @return True if the fox is still alive.
     */
//    public boolean isAlive() {
//        return alive;
//    }

    /**
     * Set the animal's location.
     *
     * @param row The vertical coordinate of the location.
     * @param col The horizontal coordinate of the location.
     */
//    public void setLocation(int row, int col) {
//        this.location = new Location(row, col);
//    }

    /**
     * Set the rabbit's location.
     *
     * @param location The rabbit's location.
     */
//    public void setLocation(Location location) {
//        this.location = location;
//    }
}
