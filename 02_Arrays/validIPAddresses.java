public class Solution {
    public String[] restoreIpAddresses(String A) {
        if(A != null){
            ArrayList<String> result = new ArrayList<String>();
            LinkedList<String> current = new LinkedList<String>();
            int level = 4;
            
            checkIp(A, result, current, level);
            
            String[] array = new String[result.size()];
            for(int i = 0; i < array.length; i++){
                array[i] = result.get(i);
            }
            return array;
        }
        return null;
    }
    public void checkIp(String A, ArrayList<String> result, LinkedList<String> current, int level){
	    if(A != null && level > 0){
	        
    		int n = A.length();
    		//int min = n / level;
    		int min = 1;
    		int temp = 0;
    		String s = null;
    		int max = n >= 3 ? 3 : n;
    		for(int i = min; i <= max; i++){
    			s = A.substring(0, i);
    			if(isValidIp(s)){
    				current.add(s);
    				//Execute on lower level
    				if(i < n){
    				    temp = level - 1;
    				    checkIp(A.substring(i, n), result, current, temp);
    				}
    				    
    				if(level == 1 && A.length() == s.length()){
    					//Final level : Insert
    					result.add(formatResult(current));
    				}
    				//Remove last segment
    				current.removeLast();
    			}
    		}
    	}	
    }
    public boolean isValidIp(String ip){
        if(ip != null){
            if(Integer.valueOf(ip) > 255)
                return false;
            else if(ip.charAt(0) == '0' && ip.length() > 1)
                return false;
            else
                return true;
        }
        return false;
    }
    
    public String formatResult(LinkedList<String> list){
        if(list != null){
            StringBuilder s = new StringBuilder();
            Object[] array = list.toArray();
            for(int i = 0; i < array.length; i++){
                s.append(String.valueOf(array[i]));
                if(i < array.length - 1)
                    s.append('.');
            }
            return s.toString();
        }
        return null;
    }
}
