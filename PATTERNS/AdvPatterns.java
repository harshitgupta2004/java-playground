class AdvPattens {

    // HOLLOW RECTANGLE
    public static void hollow_rectangle(int totRows, int totCols) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {

            // inner loop - columns
            for (int j = 1; j <= totCols; j++) {
                // cell - (i,j)
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    // boundary cells
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    // INVERTED AND ROTATED HALF-PYRAMID
    public static void inerted_rotated_half_pyramid(int totRows) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // spaces
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // INVERTED HALF-PYRAMID WITH NUMBERS

    public static void inverted_half_pyramid_withNumbers(int totRows) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // inner loop - numbers
            for (int j = 1; j <= totRows - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // FLOYD'S TRIANGLE PATTERN
    public static void Floyd_Traingle(int totRows) {
        // outer loop
        int counter = 1;
        for (int i = 1; i <= totRows; i++) {
            // inner loop - how many times will counter be printed
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    // 0-1 TRIANGLE
    public static void zero_one_Triangle(int totRows) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // inner loop
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) { // even
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }

    // BUTTERFLY PATTERN
    public static void butterfly_pattern(int totRows) {

        // IST HALF
        // outer loop
        for (int i = 1; i <= totRows; i++) {

            // in one line- stars + spaces + stars
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 1; j <= 2 * (totRows - i); j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 2ND HALF
        // outer loop
        for (int i = totRows; i >= 1; i--) {

            // in one line- stars + spaces + stars
            // stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // spaces - 2*(totRows-i)
            for (int j = 1; j <= 2 * (totRows - i); j++) {
                System.out.print(" ");
            }

            // stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // SOLID RHOMBUS
    public static void solid_Rombus(int totRows) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // inner loop
            // spaces
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= totRows; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // HOLLOW RHOMBUS
    public static void hollow_Rhombus(int totRows) {
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // spaces
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print(" ");
            }

            // boundary - hollow rectangle - stars
            for (int j = 1; j <= totRows; j++) {
                if (i == 1 || i == totRows || j == 1 || j == totRows) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    // DIAMOND PATTERN
    public static void diamond_pattern(int totRows) {

        // 1ST HALF
        // outer loop
        for (int i = 1; i <= totRows; i++) {
            // inner loop
            // spaces
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2ND HALF
        // outer loop
        for (int i = totRows; i >= 1; i--) {
            // inner loop
            // spaces
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // hollow_rectangle(4, 5);
        // inerted_rotated_half_pyramid(4);
        // inverted_half_pyramid_withNumbers(5);
        // Floyd_Traingle(5);
        // zero_one_Triangle(5);
        // butterfly_pattern(4);
        // solid_Rombus(5);
        // hollow_Rhombus(5);
        diamond_pattern(4);
    }
}