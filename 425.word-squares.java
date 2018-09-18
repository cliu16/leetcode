class Solution {
    class Trie{
        class Node{
            Node[] children;
            boolean isEnd;
            List<String> words;

            public Node(){
                children = new Node[26];
                isEnd = false;
                words = new ArrayList<>();
            }
        }

        private Node root;
        
        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node now = root;
            for(int i = 0; i < word.length(); i++){
                char cur = word.charAt(i);
                if(now.children[cur - 'a'] == null){
                    now.children[cur - 'a'] = new Node();
                }

                now = now.children[cur - 'a'];
                now.words.add(word);
            }
        }

        public List<String> prefixWords(String word){
            List<String> ret = new ArrayList<>();
            Node node = searchNode(word);
            if(node == null){
                return ret;
            }
            ret.addAll(node.words);
            return ret;
        }

        public Node searchNode(String word){
            Node now = root;
            for(int i = 0; i < word.length(); i++){
                char cur = word.charAt(i);
                if(now.children[cur - 'a'] == null){
                    return null;
                }
                now = now.children[cur - 'a'];
            }
            return now;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        int len = words[0].length();
        List<List<String>> ret = new ArrayList<>();
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }

        List<String> tmp = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            tmp.add(words[i]);
            dfs(tmp, ret, len, trie);
            tmp.remove(tmp.size() - 1);
        }
        return ret;
        
    }

    private void dfs(List<String> tmp, List<List<String>> ret, int len, Trie trie){
        if(len == tmp.size()){
            ret.add(new ArrayList<>(tmp));
            return;
        }

        StringBuilder sb = new StringBuilder();
        int idx = tmp.size();
        for(String s : tmp){
            sb.append(s.charAt(idx));
        }

        for(String s : trie.prefixWords(sb.toString())){
            tmp.add(s);
            dfs(tmp, ret, len, trie);
            tmp.remove(tmp.size() - 1);
        }
    }
}
