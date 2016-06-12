public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0)return false;
        if(word.length()==0)return true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(is(i,j,board,word,0, new boolean[board.length][board[0].length])){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean is(int i,int j,char[][] b, String w, int o, boolean[][] v){
        if(0<=i&&i<b.length&&0<=j&&j<b[0].length&&v[i][j]==false&&b[i][j]==w.charAt(o)){
            v[i][j]=true;
            if(o==w.length()-1)return true;
            boolean found=is(i+1,j,b,w,o+1,v)||is(i,j+1,b,w,o+1,v)||is(i-1,j,b,w,o+1,v)||is(i,j-1,b,w,o+1,v);
            v[i][j]=false;
            return found;
        }
        return false;
    }
}