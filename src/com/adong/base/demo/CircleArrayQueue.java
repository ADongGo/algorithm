package com.adong.base.demo;

public class CircleArrayQueue {

    private int front; //指向队列的第一个元素，
    private int rear; //指向队列的最后一个元素
    private int maxSize; //队列的容量
    private int[] arr; //队列

    //创建一个队列的方法
    public CircleArrayQueue(int maxSize){
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){

        return (rear+1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){

        return front==rear;
    }

    //从队列添加数据
    public void addQueue(int add){
        if (isFull()){
            System.out.println("队列已满，不能加数据");
        }
        arr[rear]=add;
        rear=(rear+1)%maxSize;
    }

    //从队列取出数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空，不能取出数据");
        }
        int temp=arr[rear]; //用临时值存放
        front=(front+1)%maxSize;
        return temp;
    }

    //展示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列已经为空");
        }
        for(int i=front;i<front+(rear-front+maxSize)%maxSize;i++){
            System.out.println();
        }
    }
}
