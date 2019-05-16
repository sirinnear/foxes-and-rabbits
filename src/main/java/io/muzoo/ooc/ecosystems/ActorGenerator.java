package io.muzoo.ooc.ecosystems;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class ActorGenerator {

    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.03;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.05;
    // The probability that a tiger will be created in any given grid position.
    private static final double TIGER_CREATION_PROBABILITY = 0.015;
    // The probability that an actor will be created in any given grid position.
    private static final double HUNTER_CREATION_PROBABILITY = 0.005;



    protected void populate(Field field) {
        Random rand = new Random();
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    generateActor(getActors(), field, row, col, "fox");
                } else if (rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    generateActor(getActors(), field, row, col, "rabbit");
                }else if (rand.nextDouble() <= TIGER_CREATION_PROBABILITY) {
                    generateActor(getActors(), field, row, col, "tiger");
                }else if (rand.nextDouble() <= HUNTER_CREATION_PROBABILITY) {
                    generateActor(getActors(), field, row, col, "hunter");
                }
                // else leave the location empty.
            }
        }
        Collections.shuffle(getActors());
    }

    protected void generateActor(List actors, Field field, int row, int col, String animal){
        switch (animal){
            case "rabbit":
                Rabbit rabbit = new Rabbit(true);
                actors.add(rabbit);
                rabbit.setLocation(row, col);
                field.place(rabbit, row, col);
                break;
            case "fox":
                Fox fox = new Fox(true);
                actors.add(fox);
                fox.setLocation(row, col);
                field.place(fox, row, col);
                break;
            case "tiger":
                Tiger tiger = new Tiger(true);
                actors.add(tiger);
                tiger.setLocation(row, col);
                field.place(tiger, row, col);
                break;
            case "hunter":
                Hunter hunter = new Hunter(row, col);
                actors.add(hunter);
                hunter.setLocation(row, col);
                field.place(hunter, row, col);
                break;

            default:

        }
    }

    public abstract List getActors();
}
