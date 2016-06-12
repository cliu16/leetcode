public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int len = s1.length();
        int[] h = new int[256];
        for (int i = 0; i < len; i++) {
            h[s1.charAt(i)]++;
            h[s2.charAt(i)]--;
        }
        for (int i = 0; i < h.length; i++) {
            if (h[i] != 0)
                return false;
        }

        if (len <= 1)
            return true;

        for (int i = 1; i < len; i++) {
            boolean f = false;
            f = isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, len), s2.substring(i, len));
            if (f)
                return true;
            f = isScramble(s1.substring(0, i), s2.substring(len - i, len))
                    && isScramble(s1.substring(i, len),
                            s2.substring(0, len - i));
            if (f)
                return true;
        }
        return false;
    }
}
