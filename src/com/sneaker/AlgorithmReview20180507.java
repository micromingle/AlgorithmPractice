package com.sneaker;

/**
 * Created by HP on 2018/5/7.
 */
public class AlgorithmReview20180507 implements IAlgorithm {


    @Override
    public void sort(int[] array) {
        //insertionSort(array);
        // shellSort(array);
        // bubbleSort(array);
        // selectionSort(array);
        // heapSort(array);
       // quickSort(array);
        mergeSort(array);
    }

    @Override
    public void insertionSort(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int value = array[i];
            while (j - 1 >= 0 && array[j - 1] > value) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = value;
        }
    }

    @Override
    public void bubbleSort(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - i; j < len; j++) {
                if (j - 1 >= 0 && array[j - 1] > array[j]) {
                    Util.swap(array, j, j - 1);
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
                Util.swap(array, i, min);
            }
        }
    }

    @Override
    public void shellSort(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        // int gap=len;
        for (int gap = len; gap > 0; gap /= 2) {
            for (int j = 0; j < len; j += gap) {
                int pivot = array[j];
                int k = j;
                while (k - gap >= 0 && array[k - gap] > pivot) {
                    array[k] = array[k - gap];
                    k -= gap;
                }
                array[k] = pivot;
            }
        }
    }

    @Override
    public void quickSort(int[] array) {
        int len = array.length;
        quickSort(array, 0, len - 1);
    }


    public void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
    }

    public int partition(int[] array, int left, int right) {
        int index = 0;
        int i = left, j = right;
        int pivot = left + (right - left) / 2;
        while (i <= j) {
            while (array[j] > array[pivot]) {
                j--;
            }

            while (array[i] < array[pivot]) {
                i++;
            }
            if (i <= j) {
                Util.swap(array, i, j);
                i++;
                j--;
            }
        }
        index = i;
        return index;
    }

    @Override
    public void heapSort(int[] array) {
        initHeap(array);
        int len = array.length;
        for (int i = len - 1; i > -0; i--) {
            Util.swap(array, 0, i);
            buildMaxHeap(i, 0, array);
        }
    }

    private void buildMaxHeap(int heapSize, int i, int[] array) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < heapSize && array[left] > array[max]) {
            max = left;
        }
        if (right < heapSize && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
            Util.swap(array, max, i);
            buildMaxHeap(heapSize, max, array);
        }
    }

    private void initHeap(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        for (int i = len / 2; i >= 0; i--) {
            buildMaxHeap(len, i, array);
        }
    }

    @Override
    public void mergeSort(int[] array) {
        Util.checkArgs(array);
        int len = array.length;
        int[] temp = new int[len];
        mergeSort(array, 0, len - 1, temp);
    }


    public void mergeSort(int[] array, int left, int right, int tem[]) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid, tem);
            mergeSort(array, mid + 1, right, tem);
            mergeArray(array, left, right, tem);
        }
    }

    private void mergeArray(int[] array, int left, int right, int tem[]) {
        int mid = left + (right - left) / 2;
        int i = left, j = mid;
        int m = mid + 1, n = right;
        int k = 0;
        while (i <= j && m <= n) {
            if (array[i] < array[m]) {
                tem[k++] = array[i++];
            } else {
                tem[k++] = array[m++];
            }
        }
        while (i <= j) {
            tem[k++] = array[i++];
        }
        while (m <= n) {
            tem[k++] = array[m++];
        }
        for (i = 0; i < k; i++) {
            array[left + i] = tem[i];
        }
    }
}
