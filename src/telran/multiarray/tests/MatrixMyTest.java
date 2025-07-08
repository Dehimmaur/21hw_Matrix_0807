package telran.multiarray.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import telran.multiarray.tools.MatrixMy;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixMyTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/matrix.csv", numLinesToSkip = 1)
    void testMultiplyCSV(String matrixStr1, String matrixStr2, String expectedStr) {
        MatrixMy m1 = new MatrixMy(readMatrix(matrixStr1));
        MatrixMy m2 = new MatrixMy(readMatrix(matrixStr2));
        MatrixMy expected = new MatrixMy(readMatrix(expectedStr));
        MatrixMy result = m1.multiply(m2);
        assertTrue(expected.equalsMatrix(result));
    }

    @Test
    void copyMatrixTest() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] copyMatrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 2, 3}, {3, 3, 3}};
        MatrixMy m1 = new MatrixMy(matrix1);
        MatrixMy copyM1 = new MatrixMy(copyMatrix1);
        MatrixMy m2 = new MatrixMy(matrix2);
        assertTrue(m1.equalsMatrix(copyM1));
        assertFalse(m1.equalsMatrix(m2));
    }

    @Test
    void testTransp(){
        int[][] arr1 = {{1,2,3}};
        int[][] arr2 = {{1},{2},{3}};
        MatrixMy matrix1 = new MatrixMy(arr1);
        MatrixMy matrix2 = new MatrixMy(arr2);
        assertTrue(matrix1.equalsMatrix(matrix2.transp()));
    }

    @Test
    void testSum() {
        int[][] matrix1 = {{1,2,3}};
        MatrixMy m1 = new MatrixMy(matrix1);
        int[][] matrix2 = {{1},{2},{3}};
        MatrixMy m2 = new MatrixMy(matrix2);
        assertEquals(6, m1.sum());
        assertEquals(6, m2.sum());
    }

    @Test
    void testShowMatrix() {
        int[][] arr = {
                {35, 38, 41, 44},
                {79, 86, 93, 100},
                {123, 134, 145, 156},
                {167, 182, 197, 212}
        };

        MatrixMy matrix1 = new MatrixMy(arr);
        System.out.println("matrix1: ");
        matrix1.showMatrix();
        MatrixMy matrix2 = new MatrixMy(matrix1);
        assertTrue(matrix2.changeCell(0, 0, 0));
        assertTrue(matrix2.changeCell(1, 1, 0));
        assertTrue(matrix2.changeCell(2, 2, 0));
        assertTrue(matrix2.changeCell(3, 3, 0));
        System.out.println("matrix2: ");
        matrix2.showMatrix();
        System.out.println("matrix1: ");
        matrix1.showMatrix();
    }

    private int[][] readMatrix(String matrixStr){
        String[] s = matrixStr.split(";");
        String[] cells = s[0].split(" ");
        int[][] res = new int[s.length][cells.length];
        for (int i = 0; i < s.length; i++) {
            cells = s[i].split(" ");
            for (int j = 0; j < cells.length; j++) {
                res[i][j] = Integer.parseInt(cells[j]);
            }
        }
        return res;
    }
}