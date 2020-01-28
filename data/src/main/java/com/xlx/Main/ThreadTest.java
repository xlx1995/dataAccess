package com.xlx.Main;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author xlx
 * @descritption
 * @data 2019/12/8
 */
@Slf4j
public class ThreadTest {

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("fail to sleep ,e{}",e);
        }
    }
    public static void music(){
        for(;;){
            System.out.println("music");
            sleep(1);
        }
    }

    public static void news(){
        for(;;){
            System.out.println("news");
            sleep(1);
        }
    }

    public static void main(String[] args)  {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup threadGroup = new ThreadGroup("t1");
        System.out.println(currentGroup.getName());
        System.out.println(threadGroup.getParent() == currentGroup);
        ThreadGroup t2 = new ThreadGroup(threadGroup,"t2");
        System.out.println(t2.getParent() == threadGroup);
        System.out.println(t2.getParent().getName());




    }

}
