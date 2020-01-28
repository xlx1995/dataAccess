package com.xlx.Main;

import java.util.concurrent.TimeUnit;

/**
 * @author xlx
 * @descritption
 * @data 2020/1/13
 */
public class EventClient {

    public static void main(String[] args) {

        final EventQueue queue = new EventQueue(10);
        new Thread("Producer"){
            @Override
            public void run() {
                for(;;){
                    queue.offer(new EventQueue.Event());
                }
            }
        }.start();

        new Thread(() -> {
            for(;;){
                queue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Comsumer").start();


    }

}
