public class AbstractClasses {
    public static void main(String args[]) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);
        // Whenever we create object of a child class, then constructor og child class will not be called, but the constructor of its Parent or Super Class gets called 

        Chicken c = new Chicken();
        c.eat();
        c.walk();

        //Animal a = new Animal(); //We get error as objects of abstract class can't be created
    
    
        Mustang myHorse = new Mustang();
        // Animal -> Horse -> Mustang
    }
}

abstract class Animal {

    // Can have Constructors
    String color;

    Animal() {
        System.out.println("Animal Constructor called");
        color = "browm"; //Whenever our horse is created, then, by default, horse color will be brown untill we do changeColor
    }
    
    // Non - Abstract Method
    void eat() {
        System.out.println("Animal eats"); //This is implementation
    }

    // Abstract Method
    abstract void walk(); //There is no implementation in Abstract method
    // How tha animal walk, will not be told by this class; it will be told by its sub-class
    // The implementation of walk depends on horse and chicken, it will not depend on Animal; So, Animal just gives an idea, idea in the form that walk() fxn should always exist in an Animal whose return type shoukd be void and don't have any parameters
}

// Sub-Classes
class Horse extends Animal {
    Horse(){
        System.out.println("Horse Constructor called");
    }
    void changeColor() {
        color = "Dark brown";
    }
    void walk() {
        System.out.println("Walks on 4 legs");
    }
}
class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang Constructor called");
    }
}

class Chicken extends Animal {
    void changeColor() {
        color = "yellow";
    }
    void walk(){
        System.out.println("Walks on 2 legs");
    }
}