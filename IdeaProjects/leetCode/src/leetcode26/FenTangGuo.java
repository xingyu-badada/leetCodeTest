package leetcode26;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 575分糖果
 */
public class FenTangGuo {
    public int distributeCandies(int[] candies) {
        int count = 1;
        Arrays.sort(candies);
        for (int i = 0; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i] > candies[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public int distributeCandies1(int[] candies) {
        //创建一个Set几个，利用set集合的特性，无需无重复。
        Set<Integer> set = new HashSet<>();
        //循环将给定数组中的数全部存入set集合中，去除重复元素
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        //Math.min(a,b)比较方法中的a和b，返回小的。
        return Math.min(set.size(),candies.length/2);
    }
}
