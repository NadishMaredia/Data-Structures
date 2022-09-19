// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        
        int end = nums.length+1;
        int sum = 0;
        
        for(int i = 0;i<end;i++) {
            sum += i;
        }
        for(int i = 0;i<nums.length;i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
