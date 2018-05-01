package com.sneaker;

public class AlgorithmReview20180501 implements IAlgorithm {
    @Override
    public void sort(int[] array) {
        // insertionSort(array);
        // bubbleSort(array);
        //selectionSort(array);
        //shellSort(array);
        // heapSort(array);
        //quickSort(array);
        mergeSort(array);
    }

    //  错误写法 ： a[j-1]>value 写成了 a[j]>value;
    @Override
    public void insertionSort(int[] a) {
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

    @Override
    public void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            //int j=i;
            for (int j = len - i; j < len; j++) {
                if (j - 1 >= 0 && a[j - 1] > a[j]) {
                    Util.swap(a, j - 1, j);
                }
            }
        }
    }

    @Override
    public void selectionSort(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                Util.swap(array, min, i);
            }

        }
    }

    @Override
    public void shellSort(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        for (int gap = len; gap > 0; gap /= 2) {
            for (int i = 0; i < len; i += gap) {
                int value = array[i];
                int j = i;
                while (j - gap >= 0 && array[j - gap] > value) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = value;
            }
        }

    }

    @Override
    public void quickSort(int[] array) {
         quickSort(array,0,array.length-1);
    }

    public void quickSort(int[] array, int left,int right) {
        int index=partition(array,left,right);
        if(left<index-1){
            quickSort(array,left,index-1);
        }

        if(index<right){
            quickSort(array,index,right);
        }

    }

    public int partition(int[] a,int left, int right){
        int i=left;
        int j=right;
        int pivot=left+(right-left)/2;

        while (i<=j){

            while(i<=j&&a[j]>a[pivot]){
                j--;
            }

            while(i<=j&&a[i]<a[pivot]){
                i++;
            }
            if(i<=j){
                Util.swap(a,i,j);
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

    public void buildMaxHeap(int a[],int i, int heapSize){
        int left=2*i+1;
        int right=2*i+2;
        int max=i;
        if(left<heapSize&&a[left]>a[max]){
            max=left;
        }
        if(right<heapSize&&a[right]>a[max]){
             max=right;
        }

        if(max!=i){
            Util.swap(a,max,i);
            buildMaxHeap(a,max,heapSize);
        }
    }

    private void initHeap(int[] a){
        Util.checkArgs(a);
        int len=a.length;
//        for(int i=0;i<len/2;i++){ //错误写法
//            buildMaxHeap(a,i,len);
//        }
        for (int i = len / 2; i >= 0; i--) {
            buildMaxHeap(a, i, len);
        }
    }

    @Override
    public void mergeSort(int[] array) {
        int[] tem=new int[array.length];
        mergeSort(array,0,array.length-1,tem);


    }

    public void mergeSort(int[] a,int left,int right,int[] tem){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(a,left,mid,tem);
            mergeSort(a,mid+1,right,tem);
            mergeArray(a,left,right,tem);
        }
    }

    //错误while 要写等号
    private void mergeArray(int[] a ,int left,int right,int[] tem ){
        int mid=left+(right-left)/2;
        int k=0;
        int m=left,n=mid;
        int i=mid+1,j=right;
        while(m<=n&&i<=j){
            if(a[m]<a[i]){
                tem[k++]=a[m++];
            }else{
                tem[k++]=a[i++];
            }
        }
        while(m<=n){
            tem[k++]=a[m++];
        }
        while(i<=j){
            tem[k++]=a[i++];
        }

        for( i=0;i<k;i++){
            a[left+i]=tem[i];
        }
    }
}
