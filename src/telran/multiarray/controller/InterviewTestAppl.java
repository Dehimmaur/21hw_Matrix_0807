package telran.multiarray.controller;

import java.util.Arrays;

public class InterviewTestAppl {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];


        long start = System.nanoTime();
        fillArray(arr);
        long stop = System.nanoTime();
        System.out.println("fillArray: " + (stop - start));

        start = System.nanoTime();
        fillArrayOpt(arr);
        stop = System.nanoTime();
        System.out.println("fillArrayOpt: " + (stop - start));
    }

    private static void fillArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i * j;
            }
        }
    }


    private static void fillArrayOpt(int[][] arr) {
        System.out.println("Start fillArrayOpt");
        long s1, s2;
        int[] time1 = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            s1 = System.nanoTime();
            arr[i][i] = i*i;
            s2 = System.nanoTime();
            time1[i] = (int) (s2-s1);
            for (int j = i+1; j < arr.length ; j++) {
                int[] time2 = new int[arr.length - i];
                s1 = System.nanoTime();
                arr[i][j] = arr[j][i] = i * j;
                s2 = System.nanoTime();
                //System.out.println(s2-s1);
                sum += s2-s1;
                /*
                time2[i] = (int) (s2-s1);
                if (j+1 == arr.length) {
                    System.out.println("time2(string" + i + "): " + Arrays.toString(time2));
                }

                 */
            }
        }
        System.out.println("time1(diagonale): " + Arrays.toString(time1));
        System.out.println("time2:" + sum);
    }
}
