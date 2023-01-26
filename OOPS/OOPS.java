public class OOPS{
    public static void main (String args[]){
        Pen p1 = new Pen(); //created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);
        // p1.setColor("Yellow");
        p1.color = "Yellow"; //another way to set the color
        System.out.println(p1.color);

        // Access Modifer
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Harshit";
        myAcc.password = "joygupta"; //we cannot access password here
        myAcc.setPassword("joygupta"); //here, we can call setpassword fxn, and can set or change the password to a new value
        // But we cannot access the password even after changing it as it is private
        System.out.println(myAcc.password); //not possible to access it
    }
}

// ACCESS MODIFIERS/SPECIFIERS
class BankAccount {
    public String username; //username can/ should be visible to anyone, so it is made public
    public String password; //as password is sensitive data, so it should be made with private, so only it can be accesed within the class, and not outside
    public void setPassword(String pwd) {
        password = pwd; //here, this is acessible as we are acessing this private thing wihtin the class or fxn
    }
}

// NEW CLASS:
class Pen {
    // ATTRIBUTES
    String color;
    int tip;

    // FUNCTIONS
    void setColor(String newColor){ //newColor as argument - any new color
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}


class Student {
    String name;
    int age;
    float cgpa;

    void calcPercentage(int phy, int chem, int maths) {
        cgpa = (phy + chem + maths) / 3;
    }
}