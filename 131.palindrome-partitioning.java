/*
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (37.14%)
 * Total Accepted:    132K
 * Total Submissions: 355.4K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
	List<List<String>> ret = new ArrayList<>();
	dfs(s, 0, new ArrayList<>(), ret);
	return ret;
    }

    private void dfs(String s, int level, List<String> tmp, List<List<String>> ret){
	if(level == s.length()){
	    ret.add(new ArrayList<>(tmp));
	    return;
	}

	for(int i = level; i < s.length(); i++){
	    String cur = s.substring(level, i + 1);
	    if(!isPalindrome(cur)){
		continue;
	    }

	    tmp.add(cur);
	    dfs(s, i + 1, tmp, ret);
	    tmp.remove(tmp.size() - 1);
	}
    }

    private boolean isPalindrome(String cur){
	int s = 0, e = cur.length() - 1;
	while(s < e){
	    if(cur.charAt(s) != cur.charAt(e)){
		return false;
	    }
	    s++; e--;
	}
	return true;
    }
}
