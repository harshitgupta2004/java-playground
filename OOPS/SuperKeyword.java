public class SuperKeyword {
    public static void main(String args[]) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal {
    String color;
    Animal() {
        System.out.println("Animal Constructor is called");
    }
}

class Horse extends Animal{
    Horse() {
        super.color = "brown"; //In our immediate parent class, we set up the color property of it
        //super(); //With thi, the constructor of animal class got called
        System.out.println("Horse Constructor is called");
    }
}


