package hash;

import javax.net.ssl.SSLServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference3("abcd", "abcde"));
        System.out.println(findTheDifference3("abcd", "abcdw"));
    }

    //方式一
    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            //判断map中是否包含这个c
            if (map.containsKey(c)) {
                //如果包含，value的值要加1
                int newNum = map.get(c) + 1;
                //将更改过value的两个数据重新存入map中
                map.put(c, newNum);
                continue;
            }
            //如果不走if语句，直接将c放入map中
            map.put(c, 1);
        }
        for (char tc : t.toCharArray()) {
            //判断如果map集合中，不包含tc，就直接返回tc
            if (!map.containsKey(tc)) {
                return tc;
            }
            //查找t中出现次数多了一次
            //如果获取到到的value没有出现过，就直接返回
            if (map.get(tc) == 0) {
                return tc;
            }
            //如果当前获取的value出现过，就将value减1，并且重新存入map中。
            int newNum = map.get(tc) - 1;
            map.put(tc, newNum);
        }
        return '_';
    }

    //方式二
    public static char findTheDifference1(String s, String t) {
        //遍历s。
        for (Character c : s.toCharArray()) {
            //t替换第一个出现的位置，将遍历的c转换成字符串，
            //String的不可变特性，所以这里要用t重新接收替换后的String。
            t = t.replaceFirst(c.toString(), "");
        }
        //最后剩余的，没有替换的值，就是我想要的值，直接返回t的0位索引值。
        return t.toCharArray()[0];
    }

    //方式三
    //分别遍历s和t  将每个字母的值相加，所得的结果相减，差值就是要找的值。
    public static char findTheDifference2(String s, String t) {
        //定义两个整数变量
        int sSum = 0, tSum = 0;
        //将String变成char，
        for (Character c : s.toCharArray()) {
            //int类型的char字母相加，会自动转换ASCII码。
            sSum += c;
        }
        //与上方同理。
        for (Character tc : t.toCharArray()) {
            tSum += tc;
        }
        //最后将得到的得到的int类型，转化成为char类型。就会得到ASCII中对应的字母。
        return (char) (sSum - tSum);

    }


    //方式4
    /*
            0^0=0
            0^1=1
            所以让s和t转换成char数组后，
            ^  得到的结果，就是不一样的，或者多出的哪一个。
     */
    public static char findTheDifference3(String s, String t) {
        int result = 0;
        for (Character c : s.toCharArray()) {
            result ^= c;
        }
        for (Character c : t.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }
}
