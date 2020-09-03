public static boolean checkPermutations(String firstWord, String secondWord){
        if(firstWord == null || secondWord == null)
            return false;
        if (firstWord.length() != secondWord.length())
            return false;
        else{
            HashMap<Character, Integer> hash = new HashMap<>();
            int value;
            for (int i = 0; i < firstWord.length(); i++){
                //Constitute hash
                if(hash.putIfAbsent(firstWord.charAt(i), 1) != null){
                    //Element exists
                    value = hash.get(firstWord.charAt(i));
                    hash.replace(firstWord.charAt(i), value + 1);
                }
            }
            //Check if all elements are part of second word
            for(int i = 0; i < secondWord.length(); i++){
                if (hash.get(secondWord.charAt(i)) == null)
                    return false;
                else{
                    value = hash.get(secondWord.charAt(i));
                    if(value == 1)
                        hash.remove(secondWord.charAt(i));
                    else
                        hash.replace(secondWord.charAt(i), value - 1);
                }
            }
            //Final check
            return hash.isEmpty();
        }