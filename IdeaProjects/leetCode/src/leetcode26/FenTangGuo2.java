package leetcode26;

import java.util.Arrays;

public class FenTangGuo2 {
    //方式一  效率低
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int d = 0;
        while (candies > 0) {
            result[d % num_people] += Math.min(d + 1,candies);
            candies -= d + 1;
            d++;
        }
        return result;
    }

    //方式二  效率高。
    public int[] distributeCandies1(int candies, int num_people) {
        int[] result = new int[num_people];
        int d = 0;
        while (candies-d-1 > 0) {
            result[d % num_people] +=d + 1;
            candies -= d + 1;
            d++;
        }
        result[d%num_people]+=candies;
        return result;
    }


}
