package io.muzoo.ooc.ecosystems;

import java.util.List;

public class AnimalGenerator{

    protected void generateAnimal(List animals, Field field, int row, int col, String animal){
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
            default:

        }
    }
}
