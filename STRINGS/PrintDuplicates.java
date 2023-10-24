public class PrintDuplicates {
    public static void printDups(String s) {
        int count[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] > 1) {
                System.out.println((char) (i) + ", count = " + count[i]);
            }
        }
    }

    public static void main(String[] args) {
        String str = "test string";
        printDups(str);
    }
}
