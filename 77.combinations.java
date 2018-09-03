class Solution {
    public List<List<Integer>> combine(int n, int k) {
	List<List<Integer>> ret = new ArrayList<>();
	dfs(n, 1, k, new ArrayList<>(), ret);
	return ret;
    }

    private void dfs(int n, int level, int k, List<Integer> tmp, List<List<Integer>> ret){
	if(tmp.size() == k){
	    ret.add(new ArrayList<>(tmp));
	    return;
	}

	for(int i = level; i <= n; i++){
	    tmp.add(i);
	    dfs(n, i + 1, k, tmp, ret);
	    tmp.remove(tmp.size() - 1);
	}
	
    }
}
