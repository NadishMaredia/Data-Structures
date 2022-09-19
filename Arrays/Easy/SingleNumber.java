//https://leetcode.com/problems/single-number/
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    //Method 1: Using HashMap
    public int singleNumber(int[] nums) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> items: map.entrySet()) {
            if(items.getValue() == 1) {
                return items.getKey();
            }
        }
        return -1;
    }

    // Method 2: XOR
    public int singleNumberViaXor(int[] nums) {
    
        int x=0;
        for(Integer i: nums){
            x^=i;
        }
        return x;
    }
}
