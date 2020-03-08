
package com.mycompany.csuproject1;

import java.util.*;

/**
 *
 * @author Hastik
 */

// Data structure to store the start and finish time.
class Pair {

    int start;
    int finish;

    Pair(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
};

public class Activity_dynamic {

    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        
        List<Pair> activities = Arrays.asList(new Pair(1, 4), new Pair(3, 5),
                new Pair(0, 6), new Pair(5, 7),
                new Pair(3, 9), new Pair(5, 9),
                new Pair(6, 10), new Pair(8, 11),
                new Pair(8, 12), new Pair(2, 14),
                new Pair(12, 16));

        ActivitySelection(activities);
        
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("\nTime for execution = " + estimatedTime);
    }


    public static void ActivitySelection(List<Pair> activities) {

        List<List<Pair>> L = new ArrayList<>(activities.size());
        for (int i = 0; i < activities.size(); i++) {
            L.add(new ArrayList<>());
        }

        for (int i = 0; i < activities.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (activities.get(j).finish < activities.get(i).start && L.get(i).size() < L.get(j).size()) {
                    L.set(i, new ArrayList<>(L.get(j)));
                }
            }

            L.get(i).add(activities.get(i));
        }

        List<Pair> max = new ArrayList<>();
        for (List<Pair> pair : L) {
            if (max.size() < pair.size()) {
                max = pair;
            }
        }

        for (Pair pair : max) {
            System.out.print("(" + pair.start + ", " + pair.finish + ") ");
        }
    }

}
