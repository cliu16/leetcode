/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }

    private int dfs(TreeNode root, List<List<Integer>> ret){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left, ret);
        int right = dfs(root.right, ret);

        int depth = Math.max(left, right) + 1;

        while(ret.size() < depth){
            ret.add(new ArrayList<>());
        }

        ret.get(depth - 1).add(root.val);

        return depth;
    }
}
