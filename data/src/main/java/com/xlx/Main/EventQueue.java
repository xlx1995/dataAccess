package com.xlx.Main;

import java.util.LinkedList;

/**
 * @author xlx
 * @descritption
 * @data 2020/1/13
 */
public class EventQueue {

    private final int max;

    static class Event{

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAXNUM = 10;

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size() >= max){
                try {
                    System.out.println("the queue is full");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the new event is subbitter");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take (){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try {
                    System.out.println("the queue is empty");
                    eventQueue.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeLast();
            this.eventQueue.notify();
            System.out.println("the event :" + event +"is handled.");
            return event;
        }
    }



}
