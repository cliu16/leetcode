class Solution {
    public List<String> restoreIpAddresses(String s) {
	List<String> ret = new ArrayList<>();
	dfs(s, 0, new StringBuffer(), ret, 0);
	return ret;
    }

    private void dfs(String s, int level, StringBuffer tmp, List<String> ret, int part){
	if(part > 4){
	    return;
	}
	
	if(level == s.length() && part == 4){
	    ret.add(tmp.toString().substring(0, tmp.length() - 1));
	    return;
	}

	for(int i = level; i < s.length(); i++){
	    String cur = s.substring(level, i + 1);
	    if(!isValid(cur)){
		continue;
	    }

	    int presize = tmp.length();
	    tmp.append(cur).append('.');
	    dfs(s, i + 1, tmp, ret, part + 1);
	    tmp.setLength(presize);
	}
    }

    private boolean isValid(String cur){
	if(cur.length() == 0 || cur.length() > 3){
	    return false;
	}

	if(cur.charAt(0) == '0' && cur.length() > 1){
	    return false;
	}
	
	Integer val = Integer.valueOf(cur);
	if(val < 0 || val > 255 ){
	    return false;
	}

	return true;
    }
}
