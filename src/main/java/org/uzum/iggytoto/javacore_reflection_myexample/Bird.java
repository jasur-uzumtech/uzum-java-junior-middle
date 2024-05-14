package org.uzum.iggytoto.javacore_reflection_myexample;

public class Bird extends Animal implements Eating {
    private boolean walks;

    public Bird() {
        super("bird");
    }

    public Bird(String name) {
        super(name);
    }

    public Bird(String name, boolean walks) {
        super(name);
        setWalks(walks);
    }

    public boolean walks() {
        return walks;
    }

    public void setWalks(boolean walks) {
        this.walks = walks;
    }


    @Override
    protected String getSound() {
        return "";
    }

    @Override
    public String eats() {
        return "";
    }
}
