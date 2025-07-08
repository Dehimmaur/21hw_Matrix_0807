package telran.multiarray.tools;

import java.util.Objects;

public class Matrix {

    public static int sum(int[][] matrix) {
        // TODO
        int[][] inpMatrix = Objects.requireNonNull(copy2DMatrix(matrix));
        int sum = 0;
        for (int i = 0; i < inpMatrix.length; i++) {
            for (int j = 0; j < inpMatrix[i].length; j++) {
                sum += inpMatrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] transp(int[][] matrix) {
        // TODO
        int[][] inpMatrix = Objects.requireNonNull(copy2DMatrix(matrix));
        int[][] res = new int[inpMatrix[0].length][inpMatrix.length];
        for (int i = 0; i < inpMatrix.length; i++) {
            for (int j = 0; j < inpMatrix[i].length; j++) {
                res[j][i] = inpMatrix[i][j];
            }
        }
        return res;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        // TODO
        int[][] inpMatrix1 = Objects.requireNonNull(copy2DMatrix(matrix1));
        int[][] inpMatrix2 = Objects.requireNonNull(copy2DMatrix(matrix2));
        int size = calcSizeResult(inpMatrix1, inpMatrix2);
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res[i][j] = calcCell(inpMatrix1, inpMatrix2, i, j);
            }
        }
        return res;
    }

    public static int[][] copy2DMatrix(int[][] inpMatrix) {
        if (!isMatrix(inpMatrix)) {return null;}
        int[][] resMatrix = new int[inpMatrix.length][inpMatrix[0].length];
        for (int i = 0; i < resMatrix.length; i++) {
            for (int j = 0; j < resMatrix[0].length; j++) {
                resMatrix[i][j] = inpMatrix[i][j];
            }
        }
        return resMatrix;
    }

    public static boolean equals2DMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {return false;}
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {return false;}
            }
        }
        return true;
    }

    public static void show2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int calcCell(int[][] matrix1, int[][] matrix2, int x, int y) {
        if (calcSizeResult(matrix1, matrix2) == -1) {return -1;}
        int tempSum = 0;

        for (int i = 0; i < matrix1[0].length; i++) {
            tempSum += matrix1[x][i] * matrix2[i][y];
        }
        return tempSum;
    }

    private static int calcSizeResult(int[][] matrix1, int[][] matrix2) {
        return matrix1.length == matrix2[0].length ? matrix1.length : -1;
    }

    private static boolean isMatrix(int[][] matrix) {
        int length = matrix.length;
        if (length == 1) {return true;}
        int height = matrix[0].length;
        for (int i = 1; i < length; i++) {
            if (height != matrix[i].length) {return false;}
        }
        return true;
    }
}
