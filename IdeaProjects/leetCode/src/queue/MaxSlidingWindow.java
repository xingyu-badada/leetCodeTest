package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //记录每个窗口的最大值， n-k+1为形成的窗口个数。
        int[] result = new int[nums.length - k + 1];
        //使用队列记录最大值的后选值
        Deque<Integer> deque = new ArrayDeque<>();
        //窗口未形成的阶段
        for (int i = 0; i < k; i++) {
            print(deque);
            //每次都取队尾元素和新元素比较，如果队尾更小 就删除
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                //删除队尾元素；
                deque.pollLast();
            }
            //队尾添加元素。
            deque.offerLast(nums[i]);
        }

        //此时第一个窗口形成 deque的对头元素就是的个窗口的最大值。
        result[0] = deque.peekFirst();
        print(deque);
        //窗口已形成的阶段
        for (int i = k; i < nums.length; i++) {
            System.out.println("---第" + (i - k + 1) + "次滑动");
            //删掉的元素nums[i-k]，添加的元素。nums[i]
            if (nums[i - k] == deque.peekFirst()) {
                //如果删的是最大值，同时从deque中移除掉
                deque.pollFirst();
            }
            //新增
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                //删除队尾元素；
                deque.pollLast();
            }
            //将要添加的元素，添加在列表中
            deque.offerLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
            print(deque);
        }
        return result;
    }

    public static void print(Deque<Integer> deque) {
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
