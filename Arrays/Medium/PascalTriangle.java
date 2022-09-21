package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        int i = 0;
        
        while(i < numRows) 
        {
            List<Integer> rows = new ArrayList<>();    
            if(i == 0) {
                rows.add(1);
                res.add(rows);
            }
            
            if(i == 1) {
                rows.add(1);
                rows.add(1);
                res.add(rows);
            }
            
            if(i > 1) {
                List<Integer> prev = res.get(i-1);
                rows.add(1);
                for(int j = 1;j<prev.size();j++) {
                    rows.add(prev.get(j-1) + prev.get(j));
                }
                rows.add(1);
                res.add(rows);
            }
            i++;
            
        }
        
        return res;
    }
}
