package com.abner.algorithmDiagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归求和
 */
public class RecursiveSum {

    public static int sum(List<Integer> a){
        if (a.size()==0){
            throw new RuntimeException("array is empty");
        }
        if (a.size()==1){
            return a.get(0);
        }
        return a.remove(0)+sum(a);
    }
    public static void main(String[] args) {
        List arr = new ArrayList<>(Arrays.asList(5, 3, 6));
        System.out.println(sum(arr));

    }
}
