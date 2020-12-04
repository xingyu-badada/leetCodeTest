package array;


import java.util.Arrays;

public class RemoveElement {
    /**
     * [27. 移除元素](https://leetcode-cn.com/problems/remove-element/)
     */

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement1(arr, 2));
        System.out.println(Arrays.toString(arr));
    }

    //方式一
    public static int removeElement(int[] nums, int val) {
        //定义一个索引位指针inex
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //val为要移除的参数，
            //先把val 和数组中的元素做对比，如果不相等的话，
            if (val != nums[i]) {
                //就把nums[i]的值，赋值到index位置上。
                nums[index] = nums[i];
                //索引指针向后移动一位。
                index++;
            }
        }
        return index;
    }

    //方式二
    public static int removeElement1(int[] nums, int val) {
        //定义一个索引指针
        int index = 0;
        //记录数组的长度
        int length = nums.length;
        while (true) {
            //如果索引长度大于或等于数组长度，说明已经结束，直接返回。
            if (index >= length) return length;
            //如果数组中的index值与要删除的值相同，
            if (nums[index] == val) {
                //将相同的值和数组末尾位置的值互换。
                nums[index] = nums[length - 1];
                //将末尾值和要替换的值换位置。
                nums[length-1] = val;
                //就当做数组最后值要删除，所以少记录一个长度。
                length--;
                index--;
            } else {
                //为了预防替换的值和数组末尾的值一直。
                index++;
            }
        }
    }

}
