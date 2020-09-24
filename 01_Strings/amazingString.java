public class Solution {
    public int solve(String A) {
        if(A != null){
            HashMap<Integer, Character> hash = constituteHash();
            int count = 0;
            for(int i = 0; i < A.length(); i++){
                if(hash.containsKey((int)A.charAt(i)))
                    //Vowel found
                    count += A.length() - i;
            }
            return count % 10003;
        }
        return 0;
    }
    public HashMap<Integer, Character> constituteHash(){
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        HashMap<Integer, Character> hash = new HashMap<Integer, Character>();
        for(int i = 0; i < vowels.length; i++){
            hash.put((int)vowels[i], vowels[i]);
        }
        return hash;
    }
}
