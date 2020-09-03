public static boolean checkOneEdit(String word1, String word2){
        if(Math.abs(word1.length() - word2.length()) > 1)
            return false;
        if(word1.length() == word2.length() || word1.length() > word2.length()){
            //Replace and Remove
            return compare(word1, word2);
        }
        else{
            //Insert -- Reverse words order
            return compare(word2, word1);
        }
    }
    public static boolean compare(String word1, String word2){
        int check = 1;
        int longIndex = 0, shortIndex = 0;
        while(shortIndex < word2.length()){
            if(check == 0 && word1.charAt(longIndex) != word2.charAt(shortIndex))
                return false;
            else if(check == 1 && word1.charAt(longIndex) != word2.charAt(shortIndex)){
                check--;
                longIndex++;
                if(word1.length() == word2.length())
                    shortIndex++;
            }else if(word1.charAt(longIndex) == word2.charAt(shortIndex)){
                shortIndex++;
                longIndex++;
            }
        }
        return (check == (word1.length() - longIndex));
    }