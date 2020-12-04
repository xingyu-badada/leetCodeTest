package maopao;

public class maopao {

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 1,6,9,44,8,90,21};
        maopao.maopaopaixu(arr);
    }

    public static void maopaopaixu(int[] arr) {
        //控制循环的总次数
        for (int i = 1; i < arr.length; i++) {
            //比大小，交换的
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int v:arr){
            System.out.println(v);
        }
    }
}
