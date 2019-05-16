package io.muzoo.ooc.ecosystems;

import java.util.List;

public class ActorGenerator {

    protected void generateActor(List animals, Field field, int row, int col, String animal){
        switch (animal){
            case "rabbit":
                Rabbit rabbit = new Rabbit(true);
                animals.add(rabbit);
                rabbit.setLocation(row, col);
                field.place(rabbit, row, col);
                break;
            case "fox":
                Fox fox = new Fox(true);
                animals.add(fox);
                fox.setLocation(row, col);
                field.place(fox, row, col);
                break;
            case "tiger":
                Tiger tiger = new Tiger(true);
                animals.add(tiger);
                tiger.setLocation(row, col);
                field.place(tiger, row, col);
                break;
            case "hunter":
                Hunter hunter = new Hunter(row, col);
                animals.add(hunter);
                hunter.setLocation(row, col);
                field.place(hunter, row, col);
                break;
            default:

        }
    }
}
