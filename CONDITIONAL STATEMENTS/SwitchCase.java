// public class SwitchCase {
//     public static void main (String args[]) {
//         int number = 2;

//         switch (number) {
//             case 1: System.out.println("Samosa"); 
//                         break;
//             // isme number ki value ko 1 se compare kr rhe hain
//             case 2: System.out.println("Burger");
//                         break; 
//             // In switch, if any case mathches, then all other cases after that also mathches; 
//             // so we have to use break keyword to resolve this problem.  
//             case 3: System.out.println("Pizza");
//                         break;
//             default: System.out.println("We are dreaming");
//         }
//     }
// }

// We can also write cases in any random order
// Its not always necessary that these cases have to be integers
public class SwitchCase {
    public static void main (String args[]) {
        String numbers = "One";

        switch (numbers) {
            case "Four": System.out.println("Samosa"); 
                        break;
            // isme number ki value ko 1 se compare kr rhe hain
            case "Two": System.out.println("Burger");
                        break; 
            // In switch, if any case mathches, then all other cases after that also mathches; 
            // so we have to use break keyword to resolve this problem.  
            case "One": System.out.println("Pizza");
                        break;
            default: System.out.println("We are dreaming");
        }
    }
}