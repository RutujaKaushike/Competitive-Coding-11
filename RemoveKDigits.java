// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k == num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && c < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String str = sb.reverse().toString();
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0'){
            i++;
        }
        return str.substring(i).equals("") ? "0" : str.substring(i);
    }
}
