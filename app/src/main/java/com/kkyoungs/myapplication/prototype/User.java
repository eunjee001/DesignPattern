package com.kkyoungs.myapplication.prototype;

import androidx.annotation.NonNull;

public class User implements Cloneable{
    private String name, job;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public String getJob(){
        return this.job;
    }
    public int getAge(){
        return this.age;
    }

    /* 깊은 복사를 위해 Clone() 재정의 */
    @NonNull
    public Object clone() throws CloneNotSupportedException{
        return (User) super.clone();
    }
}
