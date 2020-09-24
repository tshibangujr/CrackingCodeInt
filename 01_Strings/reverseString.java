public class Solution {
    public String solve(String A) {
        if(A != null){
            StringBuilder result = new StringBuilder();
            String[] arr = A.split(" ",0);
            for(int i = arr.length - 1; i >= 0; i--){
                if(!arr[i].trim().isEmpty()){
                    result.append(arr[i].trim());
                    //Add blank space
                    result.append(" ");
                }
            }
            //Remove last blank
            return result.toString().trim();
        }
        return null;
    }
}