public class Qs_Exercise6 {

    //no of 7's in the array
    public static int printArr(int arr[][]) {
        int count = 0;

        for (int i = 0; i < arr.length; i++ ){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 7){
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    //Sum of nos is second row
    public static void printsum(int nums[][]) {
        int sum = 0;

        for(int j = 0; j < nums[0].length; j++){
            sum += nums[1][j];
        }
        System.out.println("Sum is: "+ sum);
    }

    // Transpose a Matrix:
    public static void printMatrix(int matrix[][]) {
        System.out.println("The matrix is: ");
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int arr[][] = {{4,7,8}, {8,8,7}};
        printArr(arr);

        int nums[][] = {{1,4,9}, {11,4,3}, {2,2,3}};
        printsum(nums);



        // Transpose a Matrix:
        int row = 2, column = 3;
        int matrix[][] = {{2,3,7}, {5,6,7}};

        //Display original matrix
        printMatrix(matrix);

        //Transpose the matrix
        int Transpose[][] = new int[column][row];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                Transpose[j][i] = matrix[i][j];
            }
        }

        //print the transposed matrix
        printMatrix(Transpose);
    }
}
