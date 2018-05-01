package com.sneaker;

import java.util.Arrays;

public class AlgorithmTest {

   static IAlgorithm mAlgorithm;

    public static void main(String[] args) {
        //int[] data={3,2,1,7,6,5,-10};
        int[] data = {3, 2, 1, 7, 6, 5, -10, 94, 9, 4, 11, -123, -12, 165, 19, 18, 17, 357, 188, 10};
        //   shellSort(data);
        // insertionSort(data);
        //  selectionSort(data);
        //  bubbleSort(data);
        //  quickSort(data, 0, data.length - 1);
        mAlgorithm=new AlgorithmReview20180501();
       // mAlgorithm=new AlgorithmReview();

        //int[] tem = new int[data.length];
        mAlgorithm.sort(data);
        //   heapSort(data);
        //insertionSort(data);
        Util.d("result:", Arrays.toString(data));
        //  System.out.print("result="+ Arrays.toString(data));
    }
}
