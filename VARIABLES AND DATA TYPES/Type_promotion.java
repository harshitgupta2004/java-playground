public class Type_promotion {
    public static void main(String args[]) {
        // char a = 'a';
        // char b = 'b';

        // System.out.println((int)a); // type casting a 
        // System.out.println((int)b);
        // System.out.println(b+a);

        // short a = 5;
        // byte b = 20;
        // char c = 'c';
        // byte bt = (byte) (a + b + c);  
        // System.out.println(bt);

        // Now, for rule 2 :
        // int a = 10; 
        // float b = 20.89f;
        // long c = 25;
        // double d = 30;
        // double ans = a+b+c+d; // it firstly converts all abcd into double then add ll
        // System.out.println(ans);

        byte b = 5;
        // byte a = b*2; // it will give error as it is an expression, and so, byte b got converted into int, 
        //so this b is an int, so it cannot convert into byte a, for that we have to do type casting.
        
        // byte a = (byte) (b * 2); this is correct method

        System.out.println(b); 

        
    }
}

// type promotion, in expression like a+b etc., byte, short, or char always automaticallly converted into int
