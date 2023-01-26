public class MethodOverloading {
    public static void main(String args[]) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum(1.6f, 1.4f));
        System.out.println(calc.sum(1, 2, 3));
    }
}

//COMPILE-TIME POLYMORPHISM
// Because before running this fxn, compiler already knows that for 4th line you have to call fxn 13th, for 5th, call 17th
class Calculator {
    int sum(int a, int b) { //fxn
        return a + b;
    }

    float sum (float a, float b) { //fxn
        return a + b;
    }

    int sum (int a, int b, int c) {
        return a + b + c;
    }
}
