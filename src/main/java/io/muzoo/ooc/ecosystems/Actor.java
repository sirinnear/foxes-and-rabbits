package io.muzoo.ooc.ecosystems;

import java.util.List;

public abstract class Actor {

    public abstract void act(Field currentField, Field updatedField, List newAnimal);
}
