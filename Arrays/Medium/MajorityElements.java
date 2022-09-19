package Arrays.Medium;

public class MajorityElements {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> item : map.entrySet())
        {
            if(item.getValue() > n/2)
                return item.getKey();
        }
        
        return -1;
    }
}
