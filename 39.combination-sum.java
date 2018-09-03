class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	Arrays.sort(candidates);
	List<List<Integer>> ret = new ArrayList<>();
	dfs(0, candidates, target, new ArrayList<>(), ret);
	return ret;
    }

    private void dfs(int level, int[] candis, int target, List<Integer> tmp, List<List<Integer>> ret){
	if(target == 0){
	    ret.add(new ArrayList<>(tmp));
	    return;
	}

	if(target < 0){
	    return;
	}
	
	for(int i = level; i < candis.length; i++){
	    tmp.add(candis[i]);
	    dfs(i, candis, target - candis[i], tmp, ret);
	    tmp.remove(tmp.size() - 1);
	}
    }
}
