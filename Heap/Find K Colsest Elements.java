658.Find K Closest Elements
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]


  
import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue <>((a, b) -> {
           int distA = Math.abs(a-x);
           int distB = Math.abs(b-x);
           if( distA == distB ){
             return Integer.compare(b, a);
           }
           return Integer.compare(distB, distA);
    });
    for(int num : arr){
        pq.offer(num);
        if(pq.size() > k){
            pq.poll();
        }
    }
    List<Integer> result = new ArrayList<>();
    new ArrayList<>();
    while(!pq.isEmpty()){
        result.add(pq.poll());
    }
    Collections. sort(result);
    return result;
    }
}
