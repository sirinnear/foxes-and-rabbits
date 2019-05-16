package io.muzoo.ooc.ecosystems;

import java.util.List;

public class ActorGenerator {

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
}
