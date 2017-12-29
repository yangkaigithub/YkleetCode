package cn.yk.testJava8StreamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Util {
    public int fun(Test1 t1){
        return t1.fun2(5);
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        integers.stream().filter(p -> p>50).forEach(System.out::println);
    }
}
