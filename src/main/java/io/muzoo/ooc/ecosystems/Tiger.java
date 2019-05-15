package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;

public class Tiger extends Animal{

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.05;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single animal, other than tiger. In effect, this is the
    // number of steps a tiger can go before it has to eat again.
    private static final int PREY_FOOD_VALUE= 3;

    public Tiger(boolean randomAge) {
        if (randomAge) {
            setAge(rand.nextInt(MAX_AGE));
            setFoodLevel(rand.nextInt(PREY_FOOD_VALUE));
        } else {
            // leave age at 0
            setFoodLevel(PREY_FOOD_VALUE);
        }
    }

    @Override
    public void act(Field currentField, Field updatedField, List newTigers) {
        incrementAge();
        incrementHunger();
        if (isAlive()) {
            // New tigers are born into adjacent locations.
            int births = breed();
            for (int b = 0; b < births; b++) {
                Tiger newTiger = new Tiger(false);
                newTigers.add(newTiger);
                Location loc = updatedField.randomAdjacentLocation(getLocation());
                newTiger.setLocation(loc);
                updatedField.place(newTiger, loc);
            }
            // Move towards the source of food if found.
            Location newLocation = findFood(currentField, getLocation());
            if (newLocation == null) {  // no food found - move randomly
                newLocation = updatedField.freeAdjacentLocation(getLocation());
            }
            if (newLocation != null) {
                setLocation(newLocation);
                updatedField.place(this, newLocation);
            } else {
                // can neither move nor stay - overcrowding - all locations taken
                setDead();
            }
        }
    }

    private Location findFood(Field field, Location location) {
        Iterator adjacentLocations =
                field.adjacentLocations(location);
        while (adjacentLocations.hasNext()) {
            Location where = (Location) adjacentLocations.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    setFoodLevel(PREY_FOOD_VALUE);
                    return where;
                }
            }else if ((animal instanceof Fox)){
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    setFoodLevel(PREY_FOOD_VALUE);
                    return where;
                }
            }
        }
        return null;
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }

    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }

    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }
}
