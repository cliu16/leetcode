public class Solution {
    /**
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        pos(A); neg(A);
        return find(A);
    }

    private void pos(int[] A){
        for(int i = 0; i < A.length; i++){
            if(A[i] <= 0){
                A[i] = 1 + A.length;
            }
        }
    }

    private void neg(int[] A){
        for(int i = 0; i < A.length; i++){
            if(Math.abs(A[i]) <= A.length){
                A[Math.abs(A[i]) - 1] = - Math.abs(A[Math.abs(A[i]) - 1]);
            }
        }
    }

    private int find(int[] A){
        for(int i = 0; i < A.length; i++){
            if(A[i] > 0){
                return i + 1;
            }
        }
        return A.length + 1;
    }

}
