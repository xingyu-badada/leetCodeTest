package Recu_digui;

import java.sql.SQLOutput;

public class hanoi {

    public static void main(String[] args) {
        hanoi(64, 'A', 'B', 'C');
    }

    //四个参数   有n个圆盘  需要从A注意移动到C  经由B
    //                       圆盘个数  起始     中间     终点
    public static void hanoi(int n, char A, char B, char C) {
        //出口
        if (n == 1) {
            System.out.println(A + "-->" + C);
            return;
        }
        hanoi(n - 1, A, C, B);
        System.out.println(A + "-->" + C);
        hanoi(n - 1, B, A, C);
    }
}
