package com.abner.algorithmDiagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveCountNum {
    public static int countNum(List<Integer> a){
        if (a.size()==0){
            return 0;
        }
        a.remove(0);
        return 1+countNum(a);
    }
    public static void main(String[] args) {
        List arr = new ArrayList<>(Arrays.asList(5, 3, 6));
        System.out.println(countNum(arr));

    }
}
