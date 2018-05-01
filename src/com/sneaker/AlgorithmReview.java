package com.sneaker;

import java.util.Arrays;

/**
 * Created by Administrator on 8/27/2016.
 */
public class AlgorithmReview implements IAlgorithm {


    @Override
    public void sort(int[] array) {
        insertionSort(array);
    }

    public  void insertionSort(int[] a) {
        Util.checkArgs(a);
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int value = a[i];
            int j = i;
            while (j - 1 >= 0 && a[j - 1] > value) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = value;
        }
    }

    public  void bubbleSort(int a[]) {
        Util.checkArgs(a);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - i; j < len; j++) {
                if (j - 1 >= 0 && a[j - 1] > a[j]) {
                    Util.swap(a, j, j - 1);
                }
            }
        }
    }

    public  void selectionSort(int[] a) {
        Util.checkArgs(a);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            int j = i;
            for (; j < len; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                Util.swap(a, i, min);
            }
        }
    }

    public  void shellSort(int a[]) {
        Util.checkArgs(a);
        int len = a.length;
        for (int gap = len; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int value = a[i];
                while (j - gap >= 0 && a[j - gap] > value) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = value;
            }
        }
    }

    @Override
    public void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    public  void quickSort(int a[], int left, int right) {
        int index = partition(a, left, right);
        if (left < index - 1) {
            quickSort(a, left, index - 1);
        }
        if (index < right) {
            quickSort(a, index, right);
        }
    }

    public  int partition(int a[], int left, int right) {
        int index = -1;
        int i = left, j = right;
        int mid = left + (right - left) / 2;
        int pivot = a[mid];
        while (i <= j) {
            while (a[j] > pivot) {
                j--;
            }
            while (a[i] < pivot) {
                i++;
            }
            if (i <= j) {
                Util.swap(a, i, j);
                j--;
                i++;
            }
        }
        index = i;
        return index;
    }

    public void heapSort(int a[]) {
        initHeap(a);
        int len = a.length;
        for (int i = len - 1; i >= 0; i--) {
            Util.swap(a, 0, i);
            buildMaxHeap(a, 0, i);
        }
    }



    public  void initHeap(int a[]) {
        Util.checkArgs(a);
        int len = a.length;
        for (int i = len / 2; i >= 0; i--) {
            buildMaxHeap(a, i, len);
        }
    }

    public  void buildMaxHeap(int a[], int index, int heapSize) {
        Util.checkArgs(a);
        int left = 2 * index+1;
        int right = left + 1;
        int max = index;
        if (left < heapSize && a[left] > a[max]) {
            max = left;
        }
        if (right < heapSize && a[right] > a[max]) {
            max = right;
        }
        if (max != index) {
            Util.swap(a, max, index);
            buildMaxHeap(a, max, heapSize);
        }
    }

    @Override
    public void mergeSort(int[] array) {
        int tem[]=new int[array.length];
        mergeSort(array,0,array.length-1,tem);
    }

    public  void mergeSort(int a[], int left, int right,int tem[]) {
       if(left<right){
           int mid=left+(right-left)/2;
           mergeSort(a,left,mid,tem);
           mergeSort(a,mid+1,right,tem);
           mergeArray(a,left,mid,right,tem);
       }
    }

    public  void mergeArray(int a[],int left,int mid,int right,int tem[]){
        int i=left,j=mid;
        int m=mid+1,n=right;
        int k=0;
        while(i<=j&&m<=n){
            if(a[i]>a[m]){
                tem[k++]=a[m++];
            }else{
                tem[k++]=a[i++];
            }
        }
        while(i<=j){
            tem[k++]=a[i++];
        }

        while(m<=n){
            tem[k++]=a[m++];
        }
        for(i=0;i<k;i++){
            a[left+i]=tem[i];
        }
    }
}
