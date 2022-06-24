import java.util.PriorityQueue;
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        int currentTime=0;
        PriorityQueue<Integer> durations=new PriorityQueue<>(Collections.reverseOrder());
        for(int ind=0;ind<courses.length;ind++){
            if(currentTime+courses[ind][0]<=courses[ind][1]){
                durations.add(courses[ind][0]);
                currentTime+=courses[ind][0];
            }
            else if(!durations.isEmpty() && durations.peek()>courses[ind][0]){
                currentTime-=durations.remove();
                durations.add(courses[ind][0]);
                currentTime+=courses[ind][0];
            }
        }
        return durations.size();
    }
}
