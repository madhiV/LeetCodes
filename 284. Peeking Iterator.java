// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> listIterator;
    int peek;
    boolean hasNext;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    listIterator=iterator;
        peek=iterator.next();
        hasNext=true;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(!listIterator.hasNext()){
            hasNext=false;
            return peek;
        }
        int nextElement=peek;
        peek=listIterator.next();
        return nextElement;
	}
	
	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}
