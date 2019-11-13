package com.xlx.study;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/10
 */
public class Dog extends Animal implements Cloneable{

    @Override
    public void eat() {
        System.out.println("dog eat");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void bark(){
        System.out.println("bakring");
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
