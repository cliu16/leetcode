class Solution {
    public List<List<String>> solveNQueens(int n) {
	List<List<String>> ret = new ArrayList<>();
	dfs(new int[n], 0, ret);
	return ret;
    }

    private void dfs(int[] board, int row, List<List<String>> ret){
	if(board.length == row){
	    ret.add(boardToString(board));
	    return;
	}

	for(int col = 0; col < board.length; col++){
	    if(!isValid(board, row, col)){
		continue;
	    }

	    board[row] = col;
	    dfs(board, row + 1, ret);
	}
    }

    private boolean isValid(int[] board, int row, int col){
	for(int r = 0; r < row; r++){
	    int c = board[r];
	    if(r == row){
		return false;
	    }

	    if(c == col){
		return false;
	    }

	    if(r + c == row + col){
		return false;
	    }

	    if(r - c == row - col){
		return false;
	    }
	}

	return true;
    }

    private List<String> boardToString(int[] board){
	List<String> ret = new ArrayList<>();
	for(int row = 0; row < board.length; row ++ ){
	    StringBuilder sb = new StringBuilder();
	    for(int col = 0; col < board.length; col++){
		if(board[row] == col){
		    sb.append('Q');
		}else{
		    sb.append('.');
		}
	    }
	    ret.add(sb.toString());
	}
	return ret;
    }
}
