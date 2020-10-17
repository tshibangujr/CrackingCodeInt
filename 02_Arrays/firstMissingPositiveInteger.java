public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A != null){
            int index = 0; //correct index of current value
            int length = - (int)Math.pow(10, String.valueOf(A.length).length());
            //Set negative values and > A.length to zero
            for(int i = 0; i < A.length; i++){
                if(A[i] < 0 || A[i] > A.length)
                    A[i] = 0;
            }
            //Use same array as bucket
            for(int i = 0; i < A.length; i++){
                //-1 means index value already set
                //if field contains value > 0, e.g. 4 and we want to set confirm that index 
                //is found => -14
                if(A[i] != 0 && A[i] != -1){
                    if(A[i] == i+1) 
                        A[i] = -1;
                    else if(A[i] >= 0){
                        index = A[i] - 1;
                        if(A[index] == 0)
                            //Empty cell
                            A[index] = -1;
                        else
                            //Bucket function, exemple: 5 will be stored as -15
                            A[index] = length - A[index];
                        A[i] = 0;
                    }
                    else{
                        
                        index = Math.abs(A[i] - length) - 1;
                        A[i] = -1;
                        if(A[index] == 0)
                            A[index] = -1;
                        else
                            //Bucket function
                            A[index] = length - A[index];
                    }
                }
            }
            //Check result
            for(int i = 0; i < A.length; i++){
                if(A[i] == 0)
                    return i + 1;
            }
            //All values are in the array
            return A.length + 1;
        }
        return -1;
    }
}