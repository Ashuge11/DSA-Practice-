650 . Course Schedule3

courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously 
for durationi days and must be finished before or on lastDayi.
You will start on the 1st day and you cannot take two or more courses simultaneously.
Return the maximum number of courses that you can take.

Example 1:
Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3
Explanation: 
There are totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

  class Solution {
    public int scheduleCourse(int[][] courses) {
       Arrays.sort(courses, (a,b) -> Integer.compare(a[1], b[1]));
       PriorityQueue<Integer> pq_max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
       int time = 0;
       for(int[] course : courses){
          int duration = course[0];
          int lastDay = course[1];

          time += duration;
          pq_max.offer(duration);
       
           if(time > lastDay){
         
             time -= pq_max.poll();
           }
       }
       return pq_max.size();
    }
}
