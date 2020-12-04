package array;

import java.util.Arrays;

/**
 * [26. 删除排序数组中的重复项]
 */
public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //定义i，用于记录当前需要在哪个索引位上替换值。
        int i = 0;
        //利用循环遍历找出重复的元素，并且覆盖
        for (int j = 1; j < nums.length; j++) {
            //判断当前数组I的索引位置上的值，是否和nums[j]相等
            if (nums[i] != nums[j]) {
                //如果不相等，就把j的值，赋值给i索引的后面位置。
                nums[i + 1] = nums[j];
                //索引位置往后挪一个。
                i++;
            }
        }
        //新数组的长度 = 最大索引数 +1；
        return i + 1;
    }
}
