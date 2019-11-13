package com.xlx.study;

import com.xlx.constants.Constants;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/10
 */
public class Test {

    public void test1(Animal animal){
        if(animal instanceof Dog){

        }
        animal.eat();
    }

    private static ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor(8,16,60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

    public static void main(String[] args) throws CloneNotSupportedException {

        Dog dog = new Dog();
        Dog clone = (Dog) dog.clone();
        clone.setName("123");
        System.out.println(dog.getName());
        Dog dog_temp = dog;
        dog_temp.setName("234");
        System.out.println(dog.getName());


    }

    public static class TestTask implements Runnable{

        @Override
        public void run() {
            System.out.println(Constants.Code.error.getCode());
        }
    }

}
