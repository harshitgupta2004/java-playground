public class StaticKeyword {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.schoolName = "DAV";

        Student s2 = new Student();
        System.out.println(s2.schoolName); 
        // In static, if an object declared your schoolname then, it will also be declared for every object

        Student s3 = new Student();
        s3.schoolName = "Govt"; //Now, s3 obj changes the static var, so it will change for every obj
        System.out.println(s2.schoolName);
    }
}

class Student {
    static int returnPercetage (int maths, int phy, int chem){ //in this, in paramters there wil be diff values, but the logic of this fxn will not change and remain same static for everyone, so we add static keyword
        return(maths+phy+chem)/3;
    }
    
    String name;
    int roll;

    static String schoolName; //any var that we made static, then, if an object changes that var, then that var got changed for everyone
 
    void getName(String name) { //Setter
        this.name = name;
    }
    String getName() { //Getter
        return this.name;
    }
}
