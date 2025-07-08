package telran.multiarray.tests;

import org.junit.jupiter.api.Test;
import telran.multiarray.tools.Matrix;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static telran.multiarray.tools.Matrix.*;


public class MatrixTest {

    int[][] matrix1 = {{1,2,3}};
    int[][] matrix2 = {{1},{2},{3}};

    @Test
    void testCopy2DMatrix(){
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] copyMatrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 7}};
        assertTrue(equals2DMatrix(copy2DMatrix(matrix1),copyMatrix1));
        assertFalse(equals2DMatrix(copy2DMatrix(matrix1),matrix2));
    }

    @Test
    void testShow2DArray(){
        int[][] arr = {
                {35, 38, 41, 44},
                {79, 86, 93, 100},
                {123, 134, 145, 156},
                {167, 182, 197, 212}
        };
        show2DArray(arr);
    }

    @Test
    void testSum() {
        assertEquals(6, Matrix.sum(matrix1));
        assertEquals(6, Matrix.sum(matrix2));
    }

    @Test
    void testTransp(){
        assertArrayEquals(matrix2, Matrix.transp(matrix1));
    }

    @Test
    void testMultiply() {
        int[][] expected = {{14}};
        assertArrayEquals(expected, Matrix.multiply(matrix1, matrix2));
        int[][] arr1 = {{1,2,3}, {4,5,6}};
        int[][] arr2 = {{1,4},{2,5},{3,6}};
        int[][] arrExpected1 = {{14,32},{32, 77}};
        assertArrayEquals(arrExpected1, Matrix.multiply(arr1, arr2));
        //=======================NewTests=======================================

        int[][] arr3 = {{1,2,3}, {4,5,6}};
        int[][] arr4 = {{7,8},{9,10},{11,12}};
        int[][] arrExpected2 = {{58,64},{139, 154}};
        assertArrayEquals(arrExpected2, Matrix.multiply(arr3, arr4));
        int[][] arr5 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        int[][] arr6 = {
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] arrExpected3 = {
                {35, 38, 41, 44},
                {79, 86, 93, 100},
                {123, 134, 145, 156},
                {167, 182, 197, 212}
        };
        assertArrayEquals(arrExpected3, Matrix.multiply(arr5, arr6));
    }
}
