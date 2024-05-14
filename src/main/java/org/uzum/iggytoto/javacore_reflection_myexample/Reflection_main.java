package org.uzum.iggytoto.javacore_reflection_myexample;

import java.lang.reflect.*;

public class Reflection_main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //  Class names (1st)
        System.out.println("*** Class names (1st) ***");
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());

        //  Class names (2nd)
        System.out.println("\n*** Class names (2nd) ***");
        Class<?> clazz1 = Class.forName("org.uzum.iggytoto.javacore_reflection_myexample.Goat");

        System.out.println(clazz1.getSimpleName());
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getCanonicalName());

        //  Class Modifiers
        System.out.println("\n*** Class Modifiers ***");
        Class<?> goatClass = Class.forName("org.uzum.iggytoto.javacore_reflection_myexample.Goat");
        Class<?> animalClass = Class.forName("org.uzum.iggytoto.javacore_reflection_myexample.Animal");

        int goatMods = goatClass.getModifiers();
        int animalMods = animalClass.getModifiers();

        System.out.println(Modifier.isPublic(goatMods));
        System.out.println(Modifier.isAbstract(animalMods));
        System.out.println(Modifier.isPublic(animalMods));

        //  Package Information
        System.out.println("\n*** Package Information ***");
        Package pkg = goatClass.getPackage();

        System.out.println(pkg.getName());

        //  Superclass
        System.out.println("\n*** Superclass ***");
        String str = "any string";

        Class<?> goatClass1 = goat.getClass();
        Class<?> goatSuperClass = goatClass1.getSuperclass();

        System.out.println(goatSuperClass.getSimpleName());
        System.out.println(str.getClass().getSuperclass().getSimpleName());

        //  Implemented Interfaces
        System.out.println("\n*** Implemented Interfaces ***");
        Class<?>[] goatInterfaces = goatClass.getInterfaces();
        Class<?>[] animalInterfaces = animalClass.getInterfaces();

        System.out.println(goatInterfaces.length);
        System.out.println(animalInterfaces.length);
        System.out.println(goatInterfaces[0]);
        System.out.println(animalInterfaces[0]);

        //   Constructors
        System.out.println("\n*** Constructors ***");
        Constructor<?>[] constructors = goatClass.getConstructors();

        System.out.println(constructors.length);;
        System.out.println(constructors[0].getName());

        // Fields
        System.out.println("\n*** Fields ***");
        Field[] fields = animalClass.getDeclaredFields();
        System.out.println(fields.length);
        for(Field field  : fields) {
            System.out.println(field.getName());
        }

        // Methods
        System.out.println("\n*** Methods ***");
        Method[] methods = animalClass.getDeclaredMethods();
        System.out.println(methods.length);
        for(Method method : methods) {
            System.out.println(method.getName());
        }

        //  Inspecting Constructors
        System.out.println("\n*** Inspecting Constructors ***");
        Class<?> birdClass = Class.forName("org.uzum.iggytoto.javacore_reflection_myexample.Bird");
        Constructor<?>[] constructorsBird = birdClass.getConstructors();

        System.out.println(constructorsBird.length);

        //   retrieving each constructor for the Bird class by passing the constructor’s parameter class types
        Constructor<?> cons1 = birdClass.getConstructor();
        Constructor<?> cons2 = birdClass.getConstructor(String.class);
        Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);

        Bird bird1 = (Bird) cons1.newInstance();
        Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
        Bird bird3 = (Bird) cons3.newInstance("Dove", true);

        System.out.println(bird1.walks() + " " + bird1.getName());
        System.out.println(bird2.walks() + " " + bird2.getName());
        System.out.println(bird3.walks() + " " + bird3.getName());

        // Inspecting Fields
        System.out.println("\n*** Inspecting Fields ***");
        Field[] publicFieldsBirds = birdClass.getFields();
        System.out.println(publicFieldsBirds.length);
        System.out.println(publicFieldsBirds[0].getName());

        Field[] privateFieldsBirds = birdClass.getDeclaredFields();
        System.out.println(privateFieldsBirds.length);
        System.out.println(privateFieldsBirds[0].getName());

        //  Accessing field values and modifying them
        System.out.println("\n*** Accessing field values and modifying them ***");
        Class<?> birdClazz = Class.forName("org.uzum.iggytoto.javacore_reflection_myexample.Bird");
        Bird bird = (Bird) birdClazz.getConstructor().newInstance();
        Field field = birdClazz.getDeclaredField("walks");
        field.setAccessible(true);

        System.out.println(field.getBoolean(bird));
        System.out.println(bird.walks());

        field.set(bird, true);

        System.out.println(field.getBoolean(bird));
        System.out.println(bird.walks());

        //  Inspecting Methods
        System.out.println("\n*** Inspecting Methods ***");
        Method[] methods1 = birdClass.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        Bird bird4 = new Bird();
        Method walksMethod = bird4.getClass().getDeclaredMethod("walks");
        Method setWalksMethod = bird4.getClass().getDeclaredMethod("setWalks", boolean.class);
        System.out.println(walksMethod);
        System.out.println(setWalksMethod);

        //   invoking a method at runtime
        System.out.println("\n*** invoking a method at runtime ***");
        boolean walks = (boolean) walksMethod.invoke(bird4);
        System.out.println(walks);
        System.out.println(bird4.walks());

        setWalksMethod.invoke(bird4, true);
        boolean walks2 = (boolean) walksMethod.invoke(bird4);
        System.out.println(walks2);
        System.out.println(bird4.walks());

    }

}
