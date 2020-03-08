
package com.mycompany.csuproject1;

/**
 *
 * @author Hastik
 */
public class Activity_Greedy {

    public static void main(String... args) {
        
        long startTime = System.nanoTime();
        
        int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};

        RECURSIVE_ACTIVITY_SELECTOR(s, f, 0, s.length);
        
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for execution = " + estimatedTime);
    }

    public static void RECURSIVE_ACTIVITY_SELECTOR(int[] s, int[] f, int k, int n) {

        if (k == 0) {
            System.out.print("(" + s[0] + ", " + f[0] + ") ");//Greedy choice WILL be part of the solution
        }
        int m = k + 1;

        while (m < n && s[m] < f[k]) {
            m = m + 1;
        }

        if (m < n) {

            System.out.print("(" + s[m] + ", " + f[m] + ") ");
            RECURSIVE_ACTIVITY_SELECTOR(s, f, m, n);
        } else {
            System.out.println("Done.");
        }
    }
}
