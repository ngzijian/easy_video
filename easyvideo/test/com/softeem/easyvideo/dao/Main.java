package com.softeem.easyvideo.dao;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	int total = 0;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strings = line.split(" ");
        //���ָ���
        int size = Integer.parseInt(strings[0]);
        //��ֵ
        int del = Integer.parseInt(strings[1]);
        //��̬��ʼ����������
        int[] ins = new int[size];
        //���ζ�ȡ��2�е�n��������
        for(int i=0;i<size;i++){
        	int nextInt = in.nextInt();
        	ins[i] = nextInt;
        }
        if(size <= 1 ){
        	System.out.println(0);
        }else{
        	//ȥ���ظ�����
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
                		
                		//��ֵΪk
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
