public class MyClass {
    public static void main(String args[]) {
      int x=10;
      int y=25;
      int z=x+y;

      int[] A = {100, 113, 110, 85, 105,102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
      int[] B = sumRange(A);
      
      MyClass.Result res = maxSubArray(B, 0, B.length/2, B.length - 1);
      System.out.println("Result = " + res.sum);
     
    }
    
    public static int[] sumRange(int[] array){
        int[] res = new int[array.length - 1];
        for(int i = 1; i < array.length; i++){
            res[i - 1] = array[i] - array[i - 1];
            //System.out.print(res[i - 1] + " ");
        }
        return res;
    }
    
    public static Result middleResult(int[] A, int low, int mid, int high){
        int sum = 0;
        int leftLow = 0;
        int leftSum = Integer.MIN_VALUE;
        for(int i = mid; i >= 0; --i){
            sum += A[i];
            if(sum > leftSum){
                leftSum = sum;
                leftLow = i;
            }
        }
        sum = 0;
        int rightHigh = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= high; i++){
            sum += A[i];
            if(sum > rightSum){
                rightSum = sum;
                rightHigh = i;
            }
        }
        Result result = new Result(leftLow, rightHigh, leftSum + rightSum);
        return result;
    }
    
    //Max sub array 
    public static Result maxSubArray(int[] A, int low, int mid, int high){
        if(low == high)
            return new Result(low, high, A[low]);
        
        int midLeft = (low + mid)/2;
        Result left = maxSubArray(A, low, midLeft, mid);
        
        int midRight = (mid+1 + high)/2;
        Result right = maxSubArray(A, mid + 1, midRight, high);
        
        Result middle = middleResult(A, low, mid, high);
        
        if(left.sum > right.sum && left.sum > middle.sum)
            return left;
        else if(right.sum > left.sum && right.sum > middle.sum)
            return right;
        else
            return middle;
    }
    
    
    
    public static class Result{
        int low;
        int high;
        int sum;
        public Result(int l, int h, int s){
            low = l;
            high = h;
            sum = s;
        }
    }
}