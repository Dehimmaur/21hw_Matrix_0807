package telran.multiarray.controller;

import java.util.Arrays;

public class InterviewTestAppl {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];

        for (int i = 0; i < 100; i++){
            fillArray(arr);
            fillArrayOpt(arr);
        }
    }

    private static void fillArray(int[][] arr) {
        //System.out.println("Start fillArray");
        long s1, s2, sLine1, sLine2;
        int[] time1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sLine1 = System.nanoTime();
            int[] time2 = new int[arr.length];
            for (int j = 0; j < arr[i].length; j++) {
                //s1 = System.nanoTime();
                arr[i][j] = i * j;
                //s2 = System.nanoTime();
                //time2[j] = (int) (s2-s1);
            }
            //System.out.println("time2(writers in arr): " + Arrays.toString(time2));
            sLine2 = System.nanoTime();
            //time1[i] = (int) (sLine2-sLine1);
        }
        System.out.print(Arrays.toString(time1) + "    ");
    }


    private static void fillArrayOpt(int[][] arr) {
        //System.out.println("Start fillArrayOpt");
        long s1, s2, sLen1, sLen2;
        int[] time1 = new int[arr.length];
        int[] timeLines = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sLen1 = System.nanoTime();
            //s1 = System.nanoTime();
            arr[i][i] = i*i;
            //s2 = System.nanoTime();
            //time1[i] = (int) (s2-s1);
            //int[] time2 = new int[arr.length];
            for (int j = i+1; j < arr.length ; j++) {
                //s1 = System.nanoTime();
                //arr[i][j] = arr[j][i] = i * j;
                //s2 = System.nanoTime();
                //System.out.println(s2-s1);
                //time2[j] = (int) (s2-s1);
                /*
                time2[i] = (int) (s2-s1);
                if (j+1 == arr.length) {
                    System.out.println("time2(string" + i + "): " + Arrays.toString(time2));
                }

                 */
            }
            sLen2 = System.nanoTime();
            timeLines[i] = (int) (sLen2-sLen1);
            //System.out.println("time2(arr[i][j] = arr[j][i] = i * j): " + Arrays.toString(time2));
        }
        System.out.println(Arrays.toString(timeLines));
        //System.out.println("time1(diagonale): " + Arrays.toString(time1));
    }
}
