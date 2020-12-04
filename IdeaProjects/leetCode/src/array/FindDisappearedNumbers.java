package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * ### 448.找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers1(nums));
    }

    /**
     * 思路：
     * 本题名叫消失的数字，是规定一个1-n的长度的数组，找寻数组中未出现的数字。
     *
     * @param nums
     * @return
     */

    //方式一
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //因为是1-n个长度的数组，所要先将数组中的重复元素去掉，
        //set集合的特性：集合中的元素，无序无重复。
        Set<Integer> set = new HashSet<>();
        //遍历给定的数据，将数组中的所有元素存入set集合中，集合会自动去取重复的元素。
        for (int num : nums) {
            set.add(num);
        }
        //创建list集合是用于装set集合中不包含的元素。
        List<Integer> result = new ArrayList<>();
        //循环给定数组中的所有元素。
        for (int i = 1; i <= nums.length; i++) {
            //将给定数组中的元素和set集合中的元素做对比，
            //如果不包含在set中，就添加至list集合中。
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        //最后将list集合返回。
        return result;
    }

    //方式二
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        //循环遍历给定的数组
        for (int i = 0; i < nums.length; i++) {
            //取给定数组的绝对值
            int num = Math.abs(nums[i]);
            //索引值等于数组中的值减一。
            int index = num - 1;
            //判断给定数组中的值，这时是否大于0。
            if (nums[index] > 0) {
                //若大于0，将值变为负数。
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //第二次判断，看看数组中的值，是否还大0，若大于0，
            // 说明此时的数组中，没有这个数字。
            if (nums[i] > 0) {
                //将索引数+1，就是这个没有的数字。
                result.add(i + 1);
            }
        }
        return result;
    }

}
