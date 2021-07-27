class Node{
    
}
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] seats=new int[times.length];
        int target=times[targetFriend][0];
        Arrays.sort(times,new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1,int[] arr2){
                if(arr1[0]>arr2[0]){
                    return 1;
                }
                return -1;
            }
        });
        for(int i=0;i<times.length;i++){ 
            for(int j=0;j<times.length;j++){
                if(seats[j]==0){
                    if(times[i][0]==target){
                        return j;
                    }
                    seats[j]=times[i][1];
                    break;
                }
                else if(seats[j]<=times[i][0]){
                    if(times[i][0]==target){
                        return j;
                    }
                    seats[j]=times[i][1];
                    break;
                }
            }
        }
        return 0;
    }
}
