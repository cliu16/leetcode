public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
            case '{':
            case '[':
            case '(':
                stack.push(s.charAt(i));
                break;
            case ']':
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
                break;
            case '}':
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
                break;
            case ')':
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
                break;
            }
        }

        return stack.isEmpty();
    }
}
