import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String s) {
        int st,en;
        List<Integer> ll=new LinkedList<>();
        int[] start=new int[26],end=new int[26],p;
        char c;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[0]>b[0]){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        
        //Finding start of each character...
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            c-=97;
            if(start[c]==-1){
                start[c]=i;
            }
            end[c]=i;
        }
        
        
        //Adding to pq...
        for(int i=0;i<26;i++){
            if(start[i]!=-1){
                pq.add(new int[]{start[i],end[i]});
            }
        }
        
        //Computing answer...
        st=en=-1;
        while(!pq.isEmpty()){
            p=pq.poll();
            if(p[0]>en){
                if(st!=-1){
                    ll.add(en-st+1);
                }
                st=p[0];
                en=p[1];
            }
            else{
                en=Math.max(en,p[1]);
            }
        }
        ll.add(en-st+1);
        return ll;
    }
}
