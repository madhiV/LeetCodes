import java.util.*;
class Solution {
    public String frequencySort(String s) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
        new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[0]<b[0]){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        int[] p;
        StringBuilder sb=new StringBuilder("");
        int[] freq=new int[123];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        for(int i=0;i<123;i++){
            if(freq[i]!=0){
                pq.add(new int[]{freq[i],i});
            }
        }
        while(!pq.isEmpty()){
            p=pq.poll();
            for(int i=0;i<p[0];i++){
                sb.append((char)(p[1]));
            }
        }
        return sb.toString();
    }
}
