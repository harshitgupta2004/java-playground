public class MethodOveriding {
    public static void main(String args[]) {
        Deer d = new Deer();
        d.eat();
    }
}

// RUN-TIME POLYMORPHISM
class Animal {
    void eat() {
        System.out.println("Eats Anything");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Eats Grass");
    }
}
