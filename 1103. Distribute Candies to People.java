class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr=new int[num_people];
        int round=0,req;
        while(candies!=0){
            for(int i=0;i<num_people;i++){
                req=i+(round*num_people)+1;
                if(req<candies){
                    arr[i]+=req;
                    candies-=req;
                }
                else{
                    arr[i]+=candies;
                    candies=0;
                    break;
                }
            }
            round++;
        }
        return arr;
    }
}
