class Solution {
    public boolean isHaving(int x,int[] tops,int[] bottoms){
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=x && bottoms[i]!=x){
                return false;
            }
        }
        return true;
    }
    public int minCount(int x,int[] tops,int[] bottoms){
        int count,min=Integer.MAX_VALUE;
        count=0;
        //Bringing x to top at each domino...
        for(int i=0;i<bottoms.length;i++){
            if(tops[i]!=x){
                count++;
            }
        }
        min=count;
        
        //Bringing x to bottom at each domino...
        count=0;
        for(int i=0;i<bottoms.length;i++){
            if(bottoms[i]!=x){
                count++;
            }
        }
        min=Math.min(min,count);
        return min;
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min=Integer.MAX_VALUE;
        
        if(isHaving(tops[0],tops,bottoms)){
            min=minCount(tops[0],tops,bottoms);
        }
        
        if(isHaving(bottoms[0],tops,bottoms)){
            min=Math.min(min,minCount(bottoms[0],tops,bottoms));
        }
        
        return min==Integer.MAX_VALUE?-1:min;
    }
}
