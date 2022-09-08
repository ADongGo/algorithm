package com.adong.base.demo;

public class ArrayQueue{

    int maxSize; //队列最大容量
    int rear; //后面指针
    int front; //前指针
    int[] arr; //数组模拟队列

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        this.rear=-1;
        this.front=-1;
        this.arr=new int[maxSize];
    }

    //添加数据到队列，进队列
    public void addQueue(int add){
        if(rear==maxSize-1){
            System.out.println("队列满，不能加数据");
            return;
        }
        rear++;
        arr[rear]=add;
    }

    //获取数据，出队列
    public int getQueue(){
        if(rear==front){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //获取所有的队列
    public void showQueue(){
        for(int i : arr){
            System.out.println(i);
        }
    }
}
