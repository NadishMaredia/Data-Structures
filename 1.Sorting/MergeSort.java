public class MergeSort {

    public void sort(int[] arr, int s, int e) {
        if(s >= e) return;

        int mid = s + (e - s) / 2;

        sort(arr, s, mid);
        sort(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }
    
    public void merge(int[] arr, int s, int m, int e) {
        int lengthOfArr1 = m - s + 1;
        int lengthOfArr2 = e - m;

        int[] left = new int[lengthOfArr1];
        int[] right = new int[lengthOfArr2];

        int k = s;
        for(int i = 0;i<lengthOfArr1;i++)
            left[i] = arr[k++];

        k = m + 1;
        for(int j = 0;j<lengthOfArr2;j++)
            right[j] = arr[k++];

        int index1 = 0, index2 = 0;
        k = s;

        while(index1 < lengthOfArr1 && index2 < lengthOfArr2) {
            if(left[index1] < right[index2]) {
                arr[k] = left[index1];
                index1++;
            } else {
                arr[k] = right[index2];
                index2++;
            }
            k++;
        }

        while(index1 < lengthOfArr1) {
            arr[k] = left[index1];
            index1++;
            k++;
        }

        while(index2 < lengthOfArr2) {
            arr[k] = right[index2];
            index2++;
            k++;
        }
    }
}
