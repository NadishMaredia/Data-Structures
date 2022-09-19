// https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=check-if-an-array-is-sorted
public class ArraySortedOrNot {
    boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        for(int i = 0;i<n-1;i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
}
