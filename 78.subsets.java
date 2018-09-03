class Solution {
    public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> ret = new ArrayList<>();
	Arrays.sort(nums);
	dfs(nums, new ArrayList<>(), ret, 0);
	return ret;
    }

    private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> ret, int level){
	ret.add(new ArrayList<>(tmp));
	for(int i = level; i < nums.length; i++){
	    tmp.add(nums[i]);
	    dfs(nums, tmp, ret, i + 1);
	    tmp.remove(tmp.size() - 1);
	}
    }
}
