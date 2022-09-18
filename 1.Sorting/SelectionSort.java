class SelectionSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0;i<n-1;i++) {
            int minIndex = i;
            for(int j = i + 1;j<n;j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
