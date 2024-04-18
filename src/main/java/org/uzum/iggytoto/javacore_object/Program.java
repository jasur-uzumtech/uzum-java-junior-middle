package org.uzum.iggytoto.javacore_object;

public class Program {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setEmail(new Email("person@outlook.com"));
        person.setName("PersonA");

        Person person_clone = (Person) person.clone();
        person_clone.getEmail().setValue("person_clone@mail.ru");

        System.out.println(person);
        System.out.println(person_clone);
    }
}
