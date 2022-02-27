package com.abner.algorithmDiagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    //这里失败了，这个感觉Java搞不定啊 怎么写呢？明天看下
    public static List quickSort(List<Integer> a){
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        ArrayList<Integer> pivots = new ArrayList<>();
        if(a.size()<2){
            return a;  //基线条件
        }else {
            Integer pivot = a.get(0); //递归条件
            for(int i=1;i<a.size();i++){
                if(a.get(i)<pivot){
                    less.add(a.get(i));
                }else if(a.get(i)>pivot){
                    greater.add(a.get(i));
                }
            }
            pivots.add(pivot);
        }
        return combineList(quickSort(less),pivots,quickSort(greater));
    }

    private static List combineList(List quickSort, ArrayList<Integer> pivots, List quickSort1) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(quickSort);
        integers.addAll(pivots);
        integers.addAll(quickSort1);
        return integers;
    }

    public static void main(String[] args) {
        List arr = new ArrayList<>(Arrays.asList(5, 3, 6,7));
        System.out.println(quickSort(arr));

    }
}
