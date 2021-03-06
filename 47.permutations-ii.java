class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
	List<List<Integer>> ret = new ArrayList<>();
	Arrays.sort(nums);
	dfs(nums, new ArrayList<>(), ret, new boolean[nums.length]);
	return ret;
    }

    private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> ret, boolean[] visited){
	if(tmp.size() == nums.length){
	    ret.add(new ArrayList<>(tmp));
	    return;
	}

	for(int i = 0; i < nums.length; i++){
	    if(visited[i]){
		continue;
	    }
	    visited[i] = true;
	    tmp.add(nums[i]);
	    dfs(nums, tmp, ret, visited);
	    tmp.remove(tmp.size() - 1);
	    visited[i] = false;

	    while(i < nums.length - 1 && nums[i] == nums[i + 1]){
		i++;
	    }
	}

    }
}
