public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> h = new HashMap<String ,Integer>();
        for(int i=0;i<words.length;i++){
            if(h.containsKey(words[i])){
                h.put(words[i],h.get(words[i])+1);
            }else{
                h.put(words[i],1);
            }
        }
        List<Integer> ret=new ArrayList<Integer>();
        int wordLen=words[0].length();
        int totalLen = wordLen*words.length;
        for(int i =0;i<s.length()-totalLen;i++){
            String cur=s.substring(i,i+wordLen);
            if(h.containsKey(cur)&&check(s,i,h,wordLen,totalLen)){
                ret.add(i);
            }
        }
        return ret;
    }
    
    private boolean check(String S, int s, HashMap<String, Integer> h, int wordLen,int totalLen){
        HashMap<String, Integer> real = new HashMap<String ,Integer>();
        
        for(int i=s;i<s-totalLen;i++){
            String cur = S.substring(i,i+wordLen);
            if(h.containsKey(cur)){
                if(real.containsKey(cur)){
                    if(real.get(cur)>=h.get(cur)){
                        return false;
                    }else{
                        real.put(cur,real.get(cur)+1);
                    }
                }else{
                    real.put(cur,1);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}