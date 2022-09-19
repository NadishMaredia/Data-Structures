public class ConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int count = 0;
        int maxZeros = 0;
        
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == 1) {
                count++;
                maxZeros = Math.max(count, maxZeros);
            } else {
                count = 0;
            }
        }
        
        return maxZeros;
    }
}
