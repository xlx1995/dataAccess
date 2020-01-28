package com.xlx.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xlx
 * @descritption
 * @data 2019/12/15
 */
public class DemoTest {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        List<String> b = list.stream().map(a -> "b").collect(Collectors.toList());
//        System.out.println(b.toString());
//        List<Integer> collect = Stream.of(1, 2, 3, 4, 5).map(i -> i * i).collect(Collectors.toList());
//        collect.stream().forEach(i -> System.out.println(i));
//          List<Map<String,String>> list = new ArrayList<>();
//         Map<String,String> map = new HashMap<>(16);
//         map.put("name","sss");
//         map.put("aaaa","ddd");
//         map.put("bbbb","aaa");
//         list.add(map);
//        Stream<String> stringStream = list.stream().map(i -> i.keySet().stream().collect(Collectors.joining(",")));
        Thread thread = new Thread(){
            int round = 1;
            @Override
            public void run() {
                while (true){
                    while (round < 4){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("波动拳第" + round + "发");
                        round++;

                    }
                    System.out.println("开始为时5s的充能");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    round = 1;
                }

            }
        };
        thread.start();


    }


}
