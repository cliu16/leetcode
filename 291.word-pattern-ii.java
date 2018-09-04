class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
	return dfs(pattern, 0, str, 0, new HashMap<Character, String>(), new HashSet<String>());
    }

    private boolean dfs(String pattern, int pLevel, String str, int sLevel, Map<Character, String> map, Set<String> set){
	if(pLevel == pattern.length() && str.length() == sLevel){
	    return true;
	}

	if(pLevel == pattern.length() || str.length() == sLevel){
	    return false;
	}

	char curPattern = pattern.charAt(pLevel);
	if(map.containsKey(curPattern)){
	    String curString = map.get(curPattern);
	    if(!str.substring(sLevel).startsWith(curString)){
		return false;
	    }
	    
	    return dfs(pattern, pLevel + 1, str, sLevel + curString.length(), map, set);
	}

	for(int i = sLevel; i < str.length(); i++){
	    String curString = str.substring(sLevel, i + 1);

	    // avoid abab -> 1111
	    if(set.contains(curString)){
		continue;
	    }

	    map.put(curPattern, curString);
	    set.add(curString);
	    
	    if(dfs(pattern, pLevel + 1, str, sLevel + curString.length(), map, set)){
		return true;
	    }
	    map.remove(curPattern);
	    set.remove(curString);
	}

	return false;
    }
}
    
