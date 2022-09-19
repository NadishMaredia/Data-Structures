//https://leetcode.com/problems/next-permutation/
package Arrays.Medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int i = size - 2;
        
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        
        if(i >= 0) {
            int j = size - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void reverse(int[] arr, int i) {
        int j = arr.length - 1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
