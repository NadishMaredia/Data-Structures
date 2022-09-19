public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int r = matrix.length;
        
        for(int i = 0;i<r;i++)
        {
            if(binarySearch(matrix[i], target)) {
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean binarySearch(int[] arr, int target)
    {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == target)
            {
                return true;
            } 
            else if (arr[mid] > target)
            {
                right = mid - 1;    
            } 
            else 
            {
                left = mid + 1;    
            }
        }
        
        return false;
    }
}
