import java.util.List;
import java.util.LinkedList;
class Solution {
    private List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinations=new LinkedList<>();
        computeCombinations(1,k,n,new LinkedList<>());
        return combinations;
    }
    private void computeCombinations(int currentNumber,int requiredNumbers,int requiredSum,List<Integer> currentList){
        if(requiredNumbers==0){
            if(requiredSum==0){
                combinations.add(clone(currentList));
            }
            return;
        }
        if(currentNumber==10 || requiredSum<0){
            return;
        }
        //Exclude
        computeCombinations(currentNumber+1,requiredNumbers,requiredSum,currentList);
        //Include
        currentList.add(currentNumber);
        computeCombinations(currentNumber+1,requiredNumbers-1,requiredSum-currentNumber,currentList);
        currentList.remove(currentList.size()-1);
    }
    private List<Integer> clone(List<Integer> originalList){
        List<Integer> duplicateList=new LinkedList<>();
        duplicateList.addAll(originalList);
        return duplicateList;
    }
}
