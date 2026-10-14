402. Remove K Digits
  Given string num representing a non-negative integer num, and an integer k, 
   return the smallest possible integer after removing k digits from num.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>stack = new  Stack <> ();
        for(int i=0; i< num.length(); i++){
            char digit = num.charAt(i);
            while(!stack.empty() && k>0 && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(!stack.empty() && k > 0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        for(char ch: stack){
            if(result.length() == 0 && ch == '0'){
                continue;
            }
            result.append(ch);
        }
       return result.length() == 0 ? "0" : result.toString();
    }
   
}
