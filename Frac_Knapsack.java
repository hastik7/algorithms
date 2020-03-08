/*
 * Reference for this pogram is taken from https://www.geeksforgeeks.org/fractional-knapsack-problem/ 
 */
import java.util.*;

/**
 *
 * @author Hastik
 */
public class Frac_Knapsack {

    public static void main(String[] args) {
        int[] val = {40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 13, 11, 8};
        int[] wt = {412, 580, 905, 485, 774, 865, 870, 460, 959, 697, 312, 784, 200, 138, 295, 154, 171, 147, 235, 301, 50, 174, 68, 14, 14, 30, 27,};
        int capacity = 5000;//in grams

        double maxValue = getMaxValue(wt, val, capacity);
        System.out.println("Total value we can pack in bag = " + maxValue);

    }

    private static double getMaxValue(int[] wt, int[] val, int capacity) {

        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }

        Arrays.sort(iVal, (ItemValue o1, ItemValue o2) -> o2.cost.compareTo(o1.cost));

        double totalValue = 0d;

        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;

            } else {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }

        }

        return totalValue;
    }

    static class ItemValue {

        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double(val / wt);
        }
    }
}
