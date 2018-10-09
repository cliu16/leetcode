/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    public int read(char[] buf, int n) {
        // Write your code here
        int p = 0;
        while(p < n){
            Character cur = read1();
            if(cur == null){
                break;
            }
            buf[p++] = cur;
        }

        return p;
    }

    char[] buffer = new char[4];
    int start = 0, end = 0;
    private Character read1(){
        if(start == end){
            end = read4(buffer);
            start = 0;
        }

        if(end == 0){
            return null;
        }

        char cur = buffer[start];
        start++;
        return cur;
    }
}
