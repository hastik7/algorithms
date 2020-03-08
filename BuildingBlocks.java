/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithams.dynamicprogramming;

import java.util.*;

/**
 *
 * @author Hastik
 */
public class BuildingBlocks {
     public int Ways(int n) {
        int[] dyn = new int[n + 1];
        
        //when there ar zero block.
        dyn[0] = 1;
        if (n < 1) {
            return dyn[n];
        }
        
        //When there is only one block.
        dyn[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dyn[i] = dyn[i - 1] + dyn[i - 2];
            
            if (i > 2) {
                dyn[i] += dyn[i - 3];
            }
        }

        return dyn[n];
    }

    public static void main(String[] args) {

        int n = 50;
        BuildingBlocks s = new BuildingBlocks();
        System.out.println(s.Ways(n));
    }
}
