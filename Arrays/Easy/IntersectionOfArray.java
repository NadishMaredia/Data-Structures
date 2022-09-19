
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfArray {
    public List<Integer> interest(int[] arr1, int[] arr2) {
       
        List<Integer> lst = new ArrayList<>();

        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                lst.add(arr1[i]);
                i++;
                j++;
            }
        }

        return lst;
    }
}
