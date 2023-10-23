public class ConstructorsTypes {
    public static void main(String args[]) {
        Student s1 = new Student(); // we know nothing about this s1 student
        Student s2 = new Student("Harshit"); // we know only name of s2
        Student s3 = new Student(123); // we know only roll no of s3
        // Student s4 = new Student("Aryan", 567);// in this, no constructor is called,
        // because there doesn't exist a constructor in which 1st parameter is a string
        // and 2nd is int
        // So, by default, above line will give error

        // COPY Constructor
        Student scopy = new Student();
        scopy.name = "Harshit";
        scopy.roll = 123;
        scopy.Password = "joy";
        scopy.marks[0] = 100;
        scopy.marks[1] = 90;
        scopy.marks[2] = 80;

        // But for some reason this, scopy student forgets his password, so we are
        // creating new object for this
        Student scopy2 = new Student(scopy); // We want that all the properties of scopy got copy into scopy2
        scopy2.Password = "abcd"; // We decide to inly copy name and roll properties and gives a new passrowrd to
                                  // scopy2
        scopy.marks[2] = 100;
        for (int i = 0; i < 3; i++) {
            System.out.println(scopy2.marks[i]);
        }
    }
}

class Student {
    String name;
    int roll;
    String Password;
    int marks[];

    // COPY Constructor
    // In this, this constructor copies the props of scopy into props of scopy2
    // SHALLOW COPY - This constructor is shallow copying
    // Student (Student scopy) { //In this, we pass Student scopy as a parameter.
    // Means, khud hi ka obj khud constructor me as a paramter aa rha hai
    // marks = new int[3];
    // this.name = scopy.name;
    // this.roll = scopy.roll;
    // this.marks = scopy.marks; //here, only reference got copied not the array;
    // marks of scopy2 only points at the array that is already created, and not
    // create a whole new array
    // So, any change made in the scopy, will also get reflected in the marks of
    // scopy2
    // }

    // DEEP COPY Constructor:
    Student(Student scopy) {
        marks = new int[3];
        this.name = scopy.name;
        this.roll = scopy.roll;
        for (int i = 0; i < marks.length; i++) { // for copying marks
            this.marks[i] = scopy.marks[i]; // In this, marks value is getting copied one by one
        }
    }

    // Non - Parameterized Constructor
    Student() {
        marks = new int[3];
        System.out.println("Constructor is called");
    }

    // If we remove the above constructor, then 3rd line will give the error
    // Java automatically creates a constructor only when we have not created any
    // other constructor

    // Parameterized Constructor
    Student(String name) {
        marks = new int[3];
        this.name = name;
    }

    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
    }
}
