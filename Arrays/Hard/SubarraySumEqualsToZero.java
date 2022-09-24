// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category[]=Hash&category[]=Hash&company[]=Amazon&company[]=Amazon&page=1&query=category[]Hashcompany[]Amazonpage1company[]Amazoncategory[]Hash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum
package Arrays.Hard;

import java.util.HashMap;

public class SubarraySumEqualsToZero {
    int maxLen(int arr[], int n)
    {
        // Your code here
        int max = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i<n;i++)
        {
            sum += arr[i];
            
            if(sum == 0) 
            {
                max = Math.max(max, i + 1);
            }
            else
            {
               if(!map.containsKey(sum)) {
                   map.put(sum, i);
               } else {
                   max = Math.max(max, i - map.get(sum));
               }
            }
            
        }
        
        return max;
    }
}
