public static String stringCompression(String word){
        if(word != null){
            int counter = 1;
            StringBuilder result = new StringBuilder();
            //Compression loop
            for(int i = 0; i < word.length() - 1; i++){
                if(word.charAt(i) == word.charAt(i + 1))
                    counter++;
                else{
                    result.append(word.charAt(i));
                    result.append(counter);
                    counter = 1;
                }
            }
            //Last element or single char string
            result.append(word.charAt(word.length()-1));
            result.append(counter);
            //Check result length
            if(result.length() >= word.length())
                return word;
            else
                return result.toString();
        }
        return "";
    }