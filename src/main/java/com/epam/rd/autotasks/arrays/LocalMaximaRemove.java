package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array;
        array = new int[]{-18, 21, 21, 21, 0, 65};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int[] maximaArray = new int[array.length];
        int mid = (array.length - 1) / 2;
        if (array[0] > array[1]) {
            maximaArray[0] = array[0];
        }
        if (array[array.length-1] > array[array.length-2]) {
            maximaArray[array.length-1] = array[array.length-1];
        }
        for (int i = 1; i < mid; i++) {
            if (array[i] > array[i+1] && array[i] > array[i-1]) {
                maximaArray[i] = array[i];
            }
        }
        for (int i = mid; i < array.length-1; i++) {
            if (array[i] > array[i+1] && array[i] > array[i-1]) {
                maximaArray[i] = array[i];
            }
        }

        List<Integer> listCopied = new ArrayList<>() {{for(int val:array) add(val);}};
        List<Integer> listToErase = new ArrayList<>() {{for(int val:maximaArray) add(val);}};
        listCopied.removeAll(listToErase);
        int[] copiedArray = new int[listCopied.size()];
        for (int i = 0; i < copiedArray.length; i++) {
            copiedArray[i] = listCopied.get(i);
        }
        //System.out.println(copiedArray.length);
        return  copiedArray;
    }
}
