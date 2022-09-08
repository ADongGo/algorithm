package com.adong.base.question;


public class Test1 {
    // 查找单链表中的倒数第k个节点

    public static void main(String[] args) {
        TNode head=new TNode(-1,null);
        head.next=new TNode(0,null);
        head.next.next=new TNode(1,null);
        head.next.next.next=new TNode(2,null);
        head.next.next.next.next=new TNode(3,null);
        head.next.next.next.next.next=new TNode(4,null);
        System.out.println(head);
        System.out.println(reverse(head));
    }

    public static TNode reverse(TNode head) {

        if (head.next == null || head.next.next == null) {
            return head;
        }
        //用指针遍历单链表
        TNode temp = head.next;
        TNode next = null;
        TNode newHead = new TNode(-1, null); //新建一个头节点
        while (temp != null) {
            next = temp.next; //先保存当前节点的下一个节点，后面要用到
            temp.next = newHead.next; //将当亲节点的下一个指向反转联链表的最前端
            newHead.next = temp;
            temp=next; //将指针后移
        }
        return newHead;
    }
}
class TNode{
    public int data;
    public TNode next;

    public TNode(int data,TNode next){
        this.data=data;
        this.next=next;
    }

    @Override
    public String toString() {
        return "TNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
