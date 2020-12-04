package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 26)));
    }

    //方式一  效率好
    public static int[] twoSum(int[] nums, int target) {
        //循环遍历数组。
        for (int i = 0; i < nums.length; i++) {
            //第二次遍历的起始位置从i+1开始，因为i之前的所有数字都已经相加过了，
            for (int j = i + 1; j < nums.length; j++) {
                //如果同一个数组里面的i+j刚好等于指定的目标数字，就说明找到了，
                if (nums[i] + nums[j] == target) {
                    //之间创建一个整数叔祖，将  i  和  j的索引位返回即可。
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //方式二
    public static int[] twoSum1(int[] nums, int target) {
        //使用map存储，<元素值，索引位置>
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int needNum =target- nums[i];
            //数组中的同一个元素，不同使用两遍
            if (map.containsKey(needNum) && map.get(needNum) != i){
                return new int[]{i,map.get(needNum)};
            }
        }

        return new int[]{-1, -1};
    }

    //方式三
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needNum =target- nums[i];
            if (map.containsKey(needNum)){
                return new int[]{i,map.get(needNum)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1, -1};
    }
}