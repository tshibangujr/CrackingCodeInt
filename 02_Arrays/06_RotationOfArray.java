public static void displayArray(int[][] result, int n){
        System.out.println("Display:");
          for(int i = 0; i < n; i++){
              for(int j = 0; j < n ; j++){
                  System.out.print(result[i][j] + " ");
              }
              System.out.println("");
          }
    }
    
    public static int[][] rotateArray(int[][] initialArray, int n){
        int lowerIndex = 0;
        int upperIndex = n - 1 ;
        int rowIndex = n - 1;
        int[] tempArray;
        int boardSize;
        while(upperIndex > lowerIndex){
            rowIndex = rowIndex - lowerIndex;
            boardSize = n - (2 * lowerIndex);
            tempArray = saveColumn(initialArray, lowerIndex, boardSize);
            
            //Counter Clockwise
            //RtoColumn
            for(int i = 0; i < boardSize; i++){
                initialArray[rowIndex - i][lowerIndex] = initialArray[lowerIndex][lowerIndex + i];
            }
            //Column to Row
            for(int i = lowerIndex; i <= rowIndex; i++){
                initialArray[lowerIndex][i] = initialArray[i][upperIndex];
            }
            //Row to Colum
            for(int i = 0; i < boardSize; i++){
                initialArray[lowerIndex + i][upperIndex] = initialArray[upperIndex][upperIndex - i];
            }

            //Finaly save TempRow into Row = upperIndex
            saveTempToRow(initialArray, tempArray, upperIndex, lowerIndex);

            //Increment counters
            lowerIndex++;
            upperIndex--;
            //displayArray(initialArray, n);
        }
        return initialArray;
    }
    
    public static int[] saveColumn(int[][] initialArray, int columnIndex, int n){
        int[] temp = new int[n];
        for(int i = 0; i < n  ; i++){
            temp [i] = initialArray[i + columnIndex][columnIndex];
        }
        return temp;
    }
    public static void swapRowToCol(int[][] initialArray, int row, int col, int n){
        for(int i = 1; i <= n; i++){
            initialArray[n - i][col] = initialArray[row][i];
        }
    }
    public static void swapColToRow(int[][] initialArray, int row, int col, int n){
        for(int i = 1; i <= n; i++){
            initialArray[row][i] = initialArray[i][col];
        }
    }
    public static void saveTempToRow(int[][] initialArray,int[] temp, int row, int lowerIndex){
        for(int i = lowerIndex; i <= row; i++){
            initialArray[row][i] = temp[i - lowerIndex];
        }
    }
