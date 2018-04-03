package com.softeem.easyvideo.dao;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	int total = 0;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strings = line.split(" ");
        //数字个数
        int size = Integer.parseInt(strings[0]);
        //差值
        int del = Integer.parseInt(strings[1]);
        //动态初始化整型数组
        int[] ins = new int[size];
        //依次读取第2行的n个正整数
        for(int i=0;i<size;i++){
        	int nextInt = in.nextInt();
        	ins[i] = nextInt;
        }
        if(size <= 1 ){
        	System.out.println(0);
        }else{
        	//去掉重复数字
            for(int i=0;i<ins.length;i++){
            	for(int j=i+1;j<ins.length;j++){
            		if(ins[j]==ins[i]&&ins[i]!=0){
            			
            			for(int k=j+1;k<ins.length;k++){
            				ins[k-1]=ins[k];
            			}
            			ins[ins.length-1]=0;
            			size--;
            			j--;
            		}
            	}
            }
            if(size == 1){
            	System.out.println(1);
            }else{
            	for(int i=0;i<size;i++){
                	for(int j=i+1;j<size;j++){
                		int del1 =Math.abs(ins[j] - ins[i]);
                		
                		//差值为k
                		if(del == del1){
                			
                			total++;
                		}
                	}
                }
                System.out.println(total);

            }
            
                    }
        
    }
}
