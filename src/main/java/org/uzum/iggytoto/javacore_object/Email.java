package org.uzum.iggytoto.javacore_object;

public class Email implements Cloneable {
    private String value;

    public Email(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
