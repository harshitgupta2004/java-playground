public class Inheritance {
    public static void main(String args[]) {
        // Fish shark = new Fish();
        // shark.eat();

        // Multi-level Inheritance
        // Dog dobby = new Dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);

        // Hierarchical Inheritance:
        Mammal anyMammal = new Mammal();
        anyMammal.breathe();
        anyMammal.walk();

        Fish shark = new Fish();
        shark.eat();
        shark.swim();

        Bird sparrow = new Bird();
        sparrow.color = "Brown";
        System.out.println(sparrow.color);
        sparrow.fly();
    }
}

// Base (Parent) Class
class Animal {
    String color; //properties

    void eat() { //fucntion
        System.out.println("Eats");
    }

    void breathe() { //fxn
        System.out.println("Breathes");
    }
}

// Derived (Child) Class / Sub Class
// class Fish extends Animal {
//     int fins;

//     void swim() {
//         System.out.println("Swims in water");
//     }
// }

// MULTI-LEVEL Inheritance
// class Mammal extends Animal {
//     int legs; //additional prop
// }

// class Dog extends Mammal {
//     String breed; //additional prop
// }

// HIERARCHICAL Inheritance
class Mammal extends Animal {
    void walk() {
        System.out.println("Walks");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("Swims");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("Fly");
    }
}