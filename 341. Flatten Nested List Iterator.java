/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> integerList;
    private int currentIndex;
    public NestedIterator(List<NestedInteger> nestedList) {
        integerList=new LinkedList<>();
        fillIntegerList(nestedList);
        currentIndex=0;
    }

    @Override
    public Integer next() {
        int currentElement=integerList.get(currentIndex);
        currentIndex++;
        return currentElement;
    }

    @Override
    public boolean hasNext() {
        return !(currentIndex==integerList.size());
    }
    
    private void fillIntegerList(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger:nestedList){
            if(nestedInteger.isInteger()){
                integerList.add(nestedInteger.getInteger());
                continue;
            }
            fillIntegerList(nestedInteger.getList());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
