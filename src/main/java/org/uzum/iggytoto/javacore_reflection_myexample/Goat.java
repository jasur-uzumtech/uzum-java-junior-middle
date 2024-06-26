package org.uzum.iggytoto.javacore_reflection_myexample;

public class Goat extends Animal implements Locomotion {
    public Goat(String name) {
        super(name);
    }

    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String eats() {
        return "grass";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }
}
