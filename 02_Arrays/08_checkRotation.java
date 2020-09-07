    public static boolean checkRotation(String first, String second){
        if(first != null && second != null){
            if(first.equals(second) || first.length() != second.length()){
                return false;
            }else{
                StringBuilder start = new StringBuilder();
                StringBuilder end = new StringBuilder();
                for(int i = 0; i < first.length(); i++){
                    start.append(second.charAt(i));
                    end.insert(0,first.charAt(first.length() - 1 - i));
                    //Check if both equals
                    if(start.toString().equals(end.toString())){
                        //Check substring from 
                        if(first.contains(second.substring(i + 1)))
                            return true;
                        else
                            return false;
                        //Return False???
                    }
                }
            }
        }
        return false;
    }