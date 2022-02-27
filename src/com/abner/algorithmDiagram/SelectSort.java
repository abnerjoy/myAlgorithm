package com.abner.algorithmDiagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//思想：给定一些无序数，首先找到其中最小的数，然后再剩下的数中找到第二小的数，以此类推，直到知道最后一个数
//        复杂度：O(n*n)n
public class SelectSort {
    //查询数组中最小的元素
    public static Integer getLowestNum(List<Integer> array){
        if(array==null||array.size()==0){
            throw new RuntimeException("array can not be empty!");
        }
        Integer lowest=array.get(0);
        for(int i=1;i<array.size();i++) {
            if(lowest>array.get(i)){
                lowest=array.get(i);
            }
        }
        return lowest;
    }

    public static List selectSort(List a){
        List result = new ArrayList<>();
        if(a==null||a.size()==0){
            throw new RuntimeException("array a can not be empty!");
        }
        int size = a.size();
        for(int i=0; i<size;i++){
            Integer lowestNum = getLowestNum(a);
            result.add(lowestNum);
            a.remove(lowestNum);
        }
        return result;
    }

    public static void main(String[] args) {
        List arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10,3));
        System.out.println(selectSort(arr));

    }

}

