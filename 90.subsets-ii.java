class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> ret = new ArrayList<>();
	Arrays.sort(nums);
	dfs(nums, 0, new ArrayList<>(), ret);

	return ret;
    }

    private void dfs(int[] nums, int level, List<Integer> tmp, List<List<Integer>> ret){
	ret.add(new ArrayList<>(tmp));

	for(int i = level; i < nums.length; i++){
	    tmp.add(nums[i]);
	    dfs(nums, i + 1, tmp, ret);
	    tmp.remove(tmp.size() - 1);

	    while(i < nums.length - 1 && nums[i] == nums[i + 1]){
		i++;
	    }
	}
    }
}
