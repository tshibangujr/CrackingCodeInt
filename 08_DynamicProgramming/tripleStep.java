public static int tripleDetails(int n, int[] memo){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] == 0)
            memo[n] = tripleDetails(n - 1, memo) + tripleDetails(n - 2, memo) + tripleDetails(n - 3, memo);
        
        return memo[n];
    }
    
public static int tripleStep(int n){
	int[] memo = new int[n + 1];
	return tripleDetails(n, memo);
	
}