class Solution {
    public int candy(int[] ratings) {
        int[] count=new int[ratings.length];
        Arrays.fill(count,1);
        int j;
        for(int i=0;i<ratings.length;i++){
            if(i-1!=-1 && ratings[i]>ratings[i-1]){
                count[i]=count[i-1]+1;
            }
            if(i+1!=ratings.length && ratings[i+1]<ratings[i]){
                j=i;
                while(j!=-1 && ratings[j]>ratings[j+1]){
                    if(count[j]>count[j+1]){
                        break;
                    }
                    count[j]=1+count[j+1];
                    j--;
                }
            }
        }
        int sum=0;
        for(int i=0;i<count.length;i++){
            sum+=count[i];
        }
        return sum;
    }
}
