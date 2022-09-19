import java.util.HashSet;

public class UnionOfArray {
    public int[] union(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i<arr1.length;i++) {
            set.add(arr1[i]);
        }
        
        for(int j = 0;j<arr2.length;j++) {
            set.add(arr2[j]);
        }

        int k = 0;
        int[] res = new int[set.size()];
        for(int i: set) {
            res[k++] = i;
        }

        return res;
    }    
}
