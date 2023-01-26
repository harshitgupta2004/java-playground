public class Interface {
    public static void main(String args[]) {
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.eat();//not able to run this mutiple inheritance
    }
}

// Blueprint that how a chess player looks
interface ChessPlayer {
    void moves(); //fxn 
}

class Queen implements ChessPlayer { //Need to recreate the fxn moves with implementation
    public void moves() { // We need to write public here, becuase if not, then, by default this moves fxn will become of default type
        System.out.println("up, down, left, right, diagonal (in all 4 dir) ");
    }
}

class Rook implements ChessPlayer { // implements derives all props of interface to that class
    public void moves() {
        System.out.println("up, down, left, right (in all 4 dir");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal (by 1 step)");
    }
}


// MULTIPLE INHERITANCE
interface Herbivore {
    default void eatGrass(){
        System.out.println("Eat grass");
    }
}

interface Carnivore {
   default void eatMeat(){
    System.out.println("Eats Meat");
   }
}

class Bear implements Herbivore, Carnivore {
    public void eat() {
        eatGrass();
        eatMeat();
    }
}