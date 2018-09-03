class Solution {
    public List<String> generateParenthesis(int n) {
	List<String> ret = new ArrayList<>();
	if(n == 0){
	    return ret;
	}
	dfs(n, n, new StringBuffer(), ret);
	return ret;
    }

    private void dfs(int left, int right, StringBuffer tmp, List<String> ret){
	if(left < 0 || right < 0 || left > right){
	    return;
	}
	if(left == 0 && right == 0){
	    ret.add(tmp.toString());
	    return;
	}

	tmp.append('(');
	dfs(left - 1, right, tmp, ret);
	tmp.setLength(tmp.length() - 1);

	tmp.append(')');
	dfs(left, right - 1, tmp, ret);
	tmp.setLength(tmp.length() - 1);
    }
}
