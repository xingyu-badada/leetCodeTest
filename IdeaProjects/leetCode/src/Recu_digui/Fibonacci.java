package Recu_digui;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(36));
    }

    //返回第N个月有多少只兔子
    public static int fib(int N) {
        if (N == 1) return 1;
        if (N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    //迭代运算方式
    public static int fib1(int N) {
        if (N == 0) return 0;
        if (N <= 1) return 1;
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N - 1];
    }
}
