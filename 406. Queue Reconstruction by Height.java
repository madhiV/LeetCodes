import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] tempArray=new int[people.length][3];
        copyArray(tempArray,people);
        int currIndex=0;
        while(currIndex<people.length){
            //HM=highest matcher
            int HM=findHighestMatcher(tempArray);
            //HMSI = Highest Matcher Smallest Index
            int HMSI=findHMSI(tempArray,HM);
            copyArray(people[currIndex],tempArray[HMSI]);
            updateGreaterValues(tempArray,HMSI);
            tempArray[HMSI][2]=-1;
            tempArray[HMSI][1]=-1;
            currIndex++;
        }
        return people;
    }
    private void copyArray(int[] peopleEntry,int[] tempEntry){
        peopleEntry[0]=tempEntry[0];
        peopleEntry[1]=tempEntry[1];
    }
    private void copyArray(int[][] tempArray,int[][] people){
        for(int ind=0;ind<people.length;ind++){
            tempArray[ind][0]=people[ind][0];
            tempArray[ind][1]=people[ind][1];
            tempArray[ind][2]=0;
        }
    }
    private int findHighestMatcher(int[][] tempArray){
        int highestMatcher=-1;
        for(int ind=0;ind<tempArray.length;ind++){
            if(tempArray[ind][1]==tempArray[ind][2]){
                highestMatcher=Math.max(highestMatcher,tempArray[ind][2]);
            }
        }
        return highestMatcher;
    }
    private int findHMSI(int[][] tempArray,int HM){
        int HMSI=-1;
        int SE=Integer.MAX_VALUE;
        for(int ind=0;ind<tempArray.length;ind++){
            if(tempArray[ind][1]==HM && SE>tempArray[ind][0]){
                HMSI=ind;
                SE=tempArray[ind][0];
            }
        }
        return HMSI;
    }
    private void updateGreaterValues(int[][] tempArray,int HMSI){
        int currentElement=tempArray[HMSI][0];
        for(int ind=0;ind<tempArray.length;ind++){
            if(ind==HMSI){
                continue;
            }
            if(tempArray[ind][0]<=currentElement){
                tempArray[ind][2]++;
            }
        }
    }
}
