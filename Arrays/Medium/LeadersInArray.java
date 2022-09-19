//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
package Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[arr.length-1]);
        
        int max_right = arr[arr.length-1];
        
        for(int i = arr.length - 2;i>=0;i--) {
            if(max_right <= arr[i]) {
                max_right = arr[i];
                res.add(max_right);
            }
        }
        
        Collections.reverse(res);
        return res;
    }
}
