package org.uzum.iggytoto.javacore_reflection;
import org.uzum.iggytoto.javacore_reflection.model.Cat;
import java.lang.reflect.*;

//  Написать программу которая создает объект Cat, устанавливает все
//  его поля в не стандартные значения без использования оператора
//  new и getter/setter методов.

public class Program {
     public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
             InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

         Class<?> catClass = Class.forName("org.uzum.iggytoto.javacore_reflection.model.Cat");
         Cat cat = (Cat) catClass.getConstructor(Integer.TYPE).newInstance(3);
         Field[] fields = catClass.getSuperclass().getDeclaredFields();

         System.out.println("*** Before ***");
         System.out.println("name: " + cat.getName() + "\nfeet: " + cat.getFeet() +
                 "\nage: " + cat.getAge());

         for (Field field : fields) {
             field.setAccessible(true);
             switch (field.getName()) {
                 case "feet" -> field.set(cat, 17);
                 case "age" -> field.set(cat, 23);
                 case "name" -> field.set(cat, "Pussy Cat");
             }
         }

         System.out.println("\n*** After ***");
         System.out.println("name: " + cat.getName() + "\nfeet: " + cat.getFeet() +
                 "\nage: " + cat.getAge());
     }
}
