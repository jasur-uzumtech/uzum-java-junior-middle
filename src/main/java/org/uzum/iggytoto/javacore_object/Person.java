package org.uzum.iggytoto.javacore_object;

import java.util.Objects;

public class Person implements Cloneable {
    private String name;
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email=" + email.toString() +
                '}';
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        clonedPerson.email = (Email) email.clone();
        return clonedPerson;
    }

}
