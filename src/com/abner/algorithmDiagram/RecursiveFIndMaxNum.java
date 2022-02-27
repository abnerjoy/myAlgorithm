package com.abner.algorithmDiagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveFIndMaxNum {
    public static int findMax(int[] arr,int leftIndex,int rightIndex){
        //基线条件
        if(leftIndex == rightIndex){
            return arr[leftIndex];
        }
        //这种方式求得mid不会溢出
        int mid = leftIndex + (rightIndex -leftIndex)/2;
        int maxLeft = findMax(arr,leftIndex,mid);
        int maxRight = findMax(arr,mid+1,rightIndex);

        return Math.max(maxLeft, maxRight);
    }



    public static void main(String[] args) {
        int[] arr={1,2,3};

        System.out.println(findMax(arr,0,2));

    }
}
