package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Actor{

    // A hunter's position
    private Location location;


    public Hunter(int row, int col){
        setLocation(row, col);
    }

    @Override
    public void act(Field currentField, Field updatedField, List newActor) {

        Location newLocation = findTarget(currentField);
        if (newLocation == null) {
            newLocation = updatedField.freeAdjacentLocation(location);
        }
        if (newLocation != null) {
            setLocation(newLocation);
            updatedField.place(this, newLocation);
        }
    }

    public Location findTarget(Field field){
        Iterator adjacentLocations =
                field.adjacentLocations(location);
        while (adjacentLocations.hasNext()) {
            Location where = (Location) adjacentLocations.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Animal){
                if (((Animal) animal).isAlive()){
                    ((Animal) animal).setDead();
                    return where; }
            }
        }
        return null;
    }

    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
