class Solution {

    private int count = 0;
    
    public int totalNQueens(int n) {
	dfs(new int[n], 0);
	return count;
    }

    private void dfs(int[] board, int row){
	if(row == board.length){
	    count++;
	    return;
	}

	for(int col = 0; col < board.length; col++){
	    if(!isValid(board, row, col)){
		continue;
	    }

	    board[row] = col;
	    dfs(board, row + 1);
	}
    }

    private boolean isValid(int[] board, int row, int col){
	for(int r = 0; r < row; r++){
	    int c = board[r];
	    if(r == row || c == col || r + c == row + col || r - c == row - col){
		return false;
	    }
	}

	return true;
    }
}
