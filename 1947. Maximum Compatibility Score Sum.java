import java.util.*;
class Solution {
    Set<Integer> set1,set2;
    int[][] students,mentors;
    int max;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.students=students;
        this.mentors=mentors;
        max=0;
        set1=new HashSet<>();
        set2=new HashSet<>();
        computeMax(0,0);
        return max;
    }
    public void computeMax(int s,int score){
        if(set1.size()==students.length){
            max=Math.max(max,score);
            return;
        }
        set1.add(s);
        for(int i=0;i<mentors.length;i++){
            if(!set2.contains(i)){
                set2.add(i);
                computeMax(s+1,score+score(s,i));
                set2.remove(i);
            }
        }
        set1.remove(s);
    }
    public int score(int s,int m){
        int score =0;
        for(int i=0;i<students[0].length;i++){
            if(students[s][i]==mentors[m][i]){
                score++;
            }
        }
        return score;
    }
}
