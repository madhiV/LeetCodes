import java.util.*;
class Solution {
    public int[] constructArray(int n, int k) {
        Deque<Integer> q=new LinkedList<>();
        int i=0;
        for(int j=1;j<=n;j++){
            q.push(j);
        }
        int[] arr=new int[n];
        while(i<(n-k)){
            arr[i]=q.pollFirst();
            i++;
        }
        while(i<n){
            arr[i]=q.pollLast();
            i++;
            if(i==n){
                break;
            }
            arr[i]=q.pollFirst();
            i++;
        }
        return arr;
    }
}
