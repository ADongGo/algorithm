package com.adong.base.demo;

public class SparseArr {

    //转换为稀疏数组的方法
    public static int[][] arr2Sparse(int[][] arr){

        //转换为稀疏数组，先得到共有多少个非零数
        int num=0;
        for (int[] srr:arr){
            for (int i:srr){
                if (i!=0)num++;
            }
        }
        //定义稀疏数组
        int[][] sparseArr=new int[num+1][3];
        sparseArr[0][0]=arr.length;
        sparseArr[0][1]=arr[0].length;
        sparseArr[0][2]=num;

        //遍历获取非零数所在的行和列
        //设置一个稀疏数组的计数器,从所需要设置的行数开始
        int row=1;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    //发现不为零的数
                    sparseArr[row][0]=i;
                    sparseArr[row][1]=j;
                    sparseArr[row++][2]=arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    public static void main(String[] args) {

        //定义一个二维数组
        int[][] arr=new int[11][11];
        System.out.println("这是原始数组");
        arr[1][2]=1;
        arr[2][3]=2;
        //输出二维数组
        for(int[] srr:arr){
            for(int i:srr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        //调用转换稀疏数组方法
        int[][] sparesArr=arr2Sparse(arr);
        System.out.println("这是稀疏数组");
        for (int[] spArr:sparesArr){
            for (int s:spArr){
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }
}
