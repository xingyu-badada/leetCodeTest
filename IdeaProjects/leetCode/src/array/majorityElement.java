package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 2};
        System.out.println(majorityElement2(nums));
    }

    /**
     * 169:多数元素
     */

    //方式一
    public static int majorityElement(int[] nums) {
        //创建一个数组，用于存放数组中的数值，还有记录数值数显的次数。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //num是给定数组中的值
            int num = nums[i];
            //count是记录数组中值出现的次数
            int count = 1;
            //如果map集合的key中，包含，num
            if (map.containsKey(num)) {
                //用过key获取value
                count = map.get(num);
                //value++
                count++;
            }
            //数组长度的一半
            int halfLen = nums.length / 2;
            //如果value中记录的count大于数组长度的一半，
            if (count > halfLen) {
                //说明存储的key就是多数元素。
                return num;
            }
            //将记录的值num，和记录出现的次数，存入集合中
            map.put(num, count);
        }
        return -1;
    }

    //方式二
    public static int majorityElement1(int[] nums) {
        //利用Arrays的排序方法，将数组先排序。
        //数组长度必须是单数，才有多数元素。
        Arrays.sort(nums);
        //获取数组一半长度
        int halfLen = nums.length / 2;
        //直接返回数组长度一般的数，就是多数元素。
        return nums[halfLen];
    }

    //方式三
    public static int majorityElement2(int[] nums) {
        //定义一个候选人，-1就说明没有。
        int candidate = -1;
        //定义一个候选人票数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果票数为0
            if (count == 0) {
                //候选人就是当前循环的值
                candidate = nums[i];
            }
            //如果此次循环的值，和候选人的值，一致。
            if (candidate == nums[i]) {
                //候选人次数+1
                count++;
            } else {
                //如果不一致，候选人次数-1
                count--;
            }
            System.out.println("元素" + nums[i] + ",次数" + count + ",候选人" + candidate);
        }
        //直接返回当前票数多的候选人。
        return candidate;
    }

}
