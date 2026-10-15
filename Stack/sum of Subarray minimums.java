907. Sum of Subarray minimums
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since 
the answer may be large, return the answer modulo 109 + 7.

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
class Solution {
    private static final int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
       
        int[] previouse = pse(arr);
        int[] next = nse(arr);
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            long  left = i - previouse[i];
            long right = next[i] - i;
            long cal = (long) arr[i] * left * right;
             sum = (sum + cal) % MOD;
        
        }
        return (int) sum;
    }
    private int[] pse(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=0 ;i<arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
               stack.pop();
            } 
            if(!stack.isEmpty()){
                result[i] = stack.peek();
            }
            else{
               result[i] = -1;
            }
            stack.push(i);
        }
        return result;
    }
    private int[] nse(int[] arr){
        Stack <Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=arr.length -1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek();
            }
            else{
               result[i] = arr.length;
            }
            stack.push(i);
        }
        return result;
    }
   
}
   
