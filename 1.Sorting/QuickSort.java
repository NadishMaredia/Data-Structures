public class QuickSort {
    public void sort(int[] arr, int s, int e) {
        if(s >= e) return;

        int pi = partition(arr, s, e);
        sort(arr, s, pi-1);
        sort(arr, pi+1, e);
    }

    public int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int countOfElementSmallerThenPivot = 0;

        for(int i = s+1;i<=e;i++) {
            if(arr[i] <= pivot) {
                countOfElementSmallerThenPivot++;
            }
        }

        int pivotIndex = s + countOfElementSmallerThenPivot;
        swap(arr, s, pivotIndex);
        
        int i = s;
        int j = e;

        while(i < pivotIndex && j > pivotIndex) {
            while(arr[i] <= pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }
            if(i < pivotIndex && j > pivotIndex) {
                swap(arr, i++, j--);
            }
        }
        return pivotIndex;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
