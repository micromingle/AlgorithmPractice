package com.sneaker;

public class AlgorithmReview20180609 implements IAlgorithm {
    @Override
    public void sort(int[] array) {
        //insertionSort(array);
        //bubbleSort(array);
       // shellSort(array);
       // selectionSort(array);
       // heapSort(array);
        //quickSort(array);
        mergeSort(array);
    }

    @Override
    public void insertionSort(int[] array) {
        Util.checkArgs(array);
        int len=array.length;
        for(int i=0;i<len;i++){
            int j=i;
            int pivot=array[j];
            while(j-1>=0&&array[j-1]>pivot){
                array[j]=array[j-1];
                j--;
            }
            array[j]=pivot;
        }

    }

    @Override
    public void bubbleSort(int[] array) {
        Util.checkArgs(array);
        int len=array.length;
        for(int i=0;i<len;i++){
            for(int j=len-i;j<len;j++){
                if(j-1>=0&&array[j-1]>array[j]){
                    Util.swap(array,j-1,j);
                }
            }
        }

    }

    @Override
    public void selectionSort(int[] array) {
        Util.checkArgs(array);
        int len=array.length;
        for(int i=0;i<len;i++){
            int minIndex=i;
            for(int j=i;j<len;j++) {
                if (array[j] < array[minIndex]) {
                    minIndex=j;
                }
            }
            Util.swap(array,minIndex,i);
        }

    }

    @Override
    public void shellSort(int[] array) {
        Util.checkArgs(array);
        int len=array.length;
        for(int gap=len/2;gap>0;gap/=2){
            for(int i=0;i<len;i+=gap){
                int j=i;
                int pivot=array[j];
                while(j-gap>=0&&array[j-gap]>pivot){
                    array[j]=array[j-gap];
                    j-=gap;
                }
                array[j]=pivot;
            }
        }

    }

    @Override
    public void quickSort(int[] array) {
       Util.checkArgs(array);
        quickSort(array,0,array.length-1);

    }

    private void quickSort(int array[],int left,int right){
        int index=partition(array,left,right);
        if(left<index-1){
           quickSort(array,left,index-1);
        }
        if(index<right){
            quickSort(array,index,right);
        }
    }

    private int partition(int []array,int left,int right){
        int middle=left+(right-left)/2;
        int pivot=array[middle];
        int i=left,j=right;
        while(i<=j){
            while (array[i]<pivot){
                i++;
            }
            while(array[j]>pivot){
                j--;
            }
            if(i<=j){
                Util.swap(array,i,j);
                i++;
                j--;
            }
        }
        return i;
    }

    @Override
    public void heapSort(int[] array) {
        initHeap(array);
        int len=array.length;
        for(int i=len-1;i>=0;i--){
            Util.swap(array,0,i);
            buildMaxHeap(array,0,i);
        }

    }

    private void buildMaxHeap(int[] array,int i,int heapSize){
        int left=2*i+1;
        int right=2*i+2;
        int max=i;
        if(left<heapSize&&array[left]>array[max]){
            max=left;
        }
        if(right<heapSize&&array[right]>array[max]){
            max=right;
        }
        if(max!=i){
            Util.swap(array,max,i);
            buildMaxHeap(array,max,heapSize);
        }

    }

    private void initHeap(int[] array){
          Util.checkArgs(array);
         int len=array.length;
         for(int i=len/2;i>=0;i--){
             buildMaxHeap(array,i,len);
         }
    }


    @Override
    public void mergeSort(int[] array) {
           Util.checkArgs(array);
           int len=array.length;
           int[] temp=new int[len];
           mergeSort(array,0,len-1,temp);
    }

    public void mergeSort(int[] array,int left,int right,int tem[]){
        int mid=left+(right-left)/2;
        if(left<right){
            mergeSort(array,left,mid,tem);
            mergeSort(array,mid+1,right,tem);
            mergeArray(array,left,mid,right,tem);
        }
    }


    private void mergeArray(int[] a,int left,int mid,int right,int tem[]) {
        int i = left, j = mid;
        int m = mid + 1, n = right;
        int k = 0;
        if (left < right) {
            while (i <= j && m <= n) {
                if (a[i] < a[m]) {
                    tem[k++] = a[i++];
                } else {
                    tem[k++] = a[m++];
                }

            }

            while (i <= j) {
                tem[k++] = a[i++];
            }

            while (m <= n) {
                tem[k++] = a[m++];
            }

            for (i = 0; i < k; i++) {
                a[left + i] = tem[i];
            }
        }
    }
}
