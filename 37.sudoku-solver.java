class Solution {
    public boolean solveSudoku(char[][] board) {
	for(int i = 0; i < 9; i++){
	    for(int j = 0; j < 9; j++){
		if(board[i][j] == '.'){
		    for(char k = '1'; k <= '9'; k++){
			board[i][j] = k;
			if(is(board, i, j) && solveSudoku(board)){
			    return true;
			}
			board[i][j] = '.';
		    }
		    return false;
		}
	    }
	}

	return true;
    }

    private boolean is(char[][] board, int a, int b ){
	for(int i = 0; i < 9; i++){
	    if(b != i && board[a][b] == board[a][i]){
		return false;
	    }

	    if(a != i && board[a][b] == board[i][b]){
		return false;
	    }
	}

	for(int i = (a/3) * 3; i < (a/3 + 1) * 3; i++){
	    for(int j = (b/3) * 3; j < (b/3 + 1) * 3; j++){
		if((a != i || b != j) && board[a][b] == board[i][j]){
		    return false;
		}
	    }
	}

	return true;
    }
}
