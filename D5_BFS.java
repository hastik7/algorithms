/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Hastik
 */
public class D5_BFS {

    public static void main(String[] args) throws java.lang.Exception {
        int M[][] = new int[][]{
        {1, 0, 1},
        {0, 0, 0},
        {1, 0, 1}};
        
        int N[][] = new int[][]{
        {1, 0, 0},
        {0, 0, 0},
        {0, 0, 0}};
        D5_BFS I = new D5_BFS();
        System.out.println("Number is: " + I.maxDistance(M));
    }

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] offsets = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] offset : offsets) {
                    int a = cur[0] + offset[0];
                    int b = cur[1] + offset[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] == 0) {
                        grid[a][b] = 1;
                        queue.offer(new int[]{a, b});
                    }
                }
            }
            level++;
        }

        return level == 0 ? -1 : level;
    }
}


