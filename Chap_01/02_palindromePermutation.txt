public static boolean palindromPermutation(String sentence){
        if(sentence == null)
            return false;
        int[] countResult = countChars(sentence);
        int blankedWordSize = sentence.length() - countResult[' '];
        int check = blankedWordSize % 2;
        
        for(int i = 0; i < countResult.length; i++){
            if(countResult[i] > 0 && (i != 32)){
                if((countResult[i] % 2 != 0) && (check == 0))
                    return false;
                if((countResult[i] % 2 == 1) && (check == 1))
                    check--;
            }
        }
        return true;
    }
    
    public static int[] countChars(String sentence){
        int[] result = new int[128];
        for(int i = 0; i < sentence.length(); i++){
            result[sentence.charAt(i)]++;
        }
        return result;
    }