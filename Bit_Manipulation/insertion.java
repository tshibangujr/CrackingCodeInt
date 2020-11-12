public static int insertionBit(int N, int M, int i, int j){
        if(j <= i)
            return N;
        else if(j > i){
            int mask = ((1 << (j - 1)) - 1);
            mask <<= i;
            mask = ~mask;
            return (N & mask) | (M << i);
        }
        return 0;
    }