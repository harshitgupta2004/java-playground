public class Constructors {
    public static void main(String args[]) {
        // Student s1 = new Student("Harshit"); //("Harshit") ye as a parameter iss
        // constructor ko paas kr skte hain, and isse hamare student ke naam ki
        // initilization ho jayegi
        // ye naam isliye print jb hua, jb humne constructor me iss value ("Harshit") ko
        // kr diya
        // System.out.println(s1.name);
        // or another way- when we don't want to pass the value in constructor
        Student s1 = new Student();
    }
}

class Student {
    String name;
    int roll;

    // Constructor - to initialize student
    // Student(String name){ //fxn constructor
    // this.name = name;
    // }
    // or
    Student() {
        System.out.println("Constructor is called...");
        // We executed when 6th line, just then, when our compiler goies in(inside) the
        // constructor, it executes print statement
    }
}
