package io.muzoo.ooc.ecosystems;

import java.util.List;

public class Hunter extends Actor{

    // A hunter's position
    private Location location;


    public Hunter(int row, int col){
        setLocation(row, col);
    }

    @Override
    public void act(Field currentField, Field updatedField, List newActor) {

    }

    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
