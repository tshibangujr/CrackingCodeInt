public static void setZeroMatrix(double[][] matrix){
        int m = matrix.length; //Number of rows
        int n = matrix[0].length; //Number of columns
        boolean[] excludedRows = new boolean[m];
        boolean[] excludedCols = new boolean[n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(excludedRows[i] == false && excludedCols[j] == false){
                        //exclude this row and col
                        excludedRows[i] = true;
                        excludedCols[j] = true;
                        //Set values of row and col to zero
                        setMatrixValue(matrix, i, j, 0);
                        break;
                    }
                }
            }
        }
    }
    //Zero based row and col
    public static void setMatrixValue(double[][] matrix, int row, int col, double value){
        int m = matrix.length; //Number of rows
        int n = matrix[0].length; //Number of columns
        if(row >= 0 && col >=0 && row <= m && col <= n){
            if(value == 0){
                for(int i = 0; i < m ; i++){
                    matrix[i][col] = 0;
                }
                for(int j = 0; j < n ; j++){
                    matrix[row][j] = 0;
                }
                    
            }else{
                matrix[row][col] = value;
            }
        }
    }
    
    public static void displayArray(double[][] result){
        int m = result.length; //Number of rows
        int n = result[0].length; //Number of columns
        System.out.println("Display:");
          for(int i = 0; i < m; i++){
              for(int j = 0; j < n ; j++){
                  System.out.print(result[i][j] + " ");
              }
              System.out.println("");
          }
    }
