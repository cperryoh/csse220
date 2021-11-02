package sll;

/**
 * This class provides a basic implementation of a singly linked list. It's
 * motivated by the implementation in Big Java, 5e, ch. 16.1.
 * 
 * @author TODO <YOUR_NAME> on <DATE>.
 */
public class SinglyLinkedList implements ILinkedList {

	/**
	 * Be sure to BOTH first and last are kept up to date in all your operations
	 */

	private ListNode first; // first holds the reference to the first node in the linked list
	private ListNode last;  // last holds the reference to the last node in the linked list
	

	/**
	 * These getters are needed for the test code.
	 */
	@Override
	public IListNode getFirst() {
		return first;
	} // getFirst

	@Override
	public IListNode getLast() {
		return last;
	} // getLast
	
	@Override
	public void setFirst(IListNode first){
		this.first = (ListNode) first;
	} // setFirst
	
	@Override
	public void setLast(IListNode last){
		this.last = (ListNode) last;
	} // setLast
	
	/**
	 * Constructs a new, empty linked list.
	 * When the list is empty, the following must be true: first = null and last = null
	 */
	public SinglyLinkedList() {
		this.first = null;
		this.last = null;
	} // SinglyLinkedList
	
	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}
		String result = "[";
		ListNode current = this.first;
		while (current.next != null) {
			result += (current.element + ", ");
			current = current.next;
		} // end while
		result += current.element + "] first=[" + this.first.getElement() + "] last=[" + this.last.getElement() + "]";
		return result;
	} // toString
	
	// --------------------------------------------------------------------------------------------------
	// From this point on is where you work
	// --------------------------------------------------------------------------------------------------
	
	/**
	 *  WARNING: add(Integer element) must be completed before OTHER tests can pass!
	 *  
	 * 	Make sure to complete this method FIRST before trying the other ones.
	 *  
	 *  This method should add the given element to the end of this list.
	 */
	@Override
	public void add(Integer element) {
		ListNode n = new ListNode(element);
		if(size()==0){
			last=n;
			first=n;
			return;
		}
		last.next=n;
		last=n;
	}

	
	/**
	 * WARNING: add(Integer element) must be completed before this test can pass!
	 * 
	 *  This method should return the number of elements in the list.
	 */
	@Override
	public Integer size() {
		ListNode e = first;
		int count=0;
		while(e!=null){
			e=e.next;
			count++;
		}
		return count;
	}
	
	
	/**
	 *  This method should insert the given element at the given index in the list.
	 *  This DOES NOT replace the element at an index, but inserts an element. 
	 *   
	 *  If you are passed an invalid index you should throw an IndexOutOfBoundsException.
     *  
     *  Note that this inserts a value at the specific index NOT a value.
     *  Please also note that it is LEGAL to insert at the END of the list.
     *  
     *  Examples:
     *  [2, 6]          ->    insertAtIndex(1, 7)    ->   [2, 7, 6]
     *  [2, 7, 6]       ->    insertAtIndex(0, 8)    ->   [8, 2, 7, 6]
     *  [8, 2, 7, 6]    ->    insertAtIndex(4, 9)    ->   [8, 2, 7, 6, 9]
     *   ^  ^  ^  ^  ^
     *   |  |  |  |  |
     *   0  1  2  3  4 <- indices 
	 */
	@Override
	public void insertAtIndex(int index, Integer element) throws IndexOutOfBoundsException {
		if (size()!=0 && index>size()){
			throw new IndexOutOfBoundsException();
		}
		if(index==0){
			ListNode n = new ListNode(element);
			if(last==null){
				last=n;
			}
			n.next=first;
			first=n;
			return;
		}
		if(index>=size()){
			add(element);
			return;
		}
		int count = 0;
		ListNode e = first;
		while(count<index-1&&e!=null){
			count++;
			e=e.next;
		}
		if(e!=null){
			ListNode newEl = new ListNode(element);
			newEl.next=e.next;
			e.next=newEl;
		}
	}
	
	
	/**
	 * 	This method should return true if the list contains the given element
	 *  and false if it does not.
	 * 
	 */
	@Override
	public boolean contains(Integer element) {
		return indexOf(element)!=-1;
	}
	public ListNode get(int index)throws IndexOutOfBoundsException{
		if(index>=size()){
			throw new IndexOutOfBoundsException();
		}
		int curIndex=0;
		ListNode e = first;
		while(e!=null){
			if(curIndex==index){
				return e;
			}
			curIndex++;
			e=e.next;
		}
		throw new NullPointerException();
	}
	
	/**
	 *  This method should attempt to remove the FIRST occurrence of the
	 *  given element in the list.
	 *  
	 *  If the element is found and removed, return true
	 *  otherwise if the element is not found, then return false.
	 */
	@Override
	public boolean remove(Integer element) {
		int index= indexOf(element);
		if(index==-1){
			return false;
		}
		ListNode el = get(index);
		if(size()==1){
			last=null;
			first=null;
			return true;
		}
		if(index==0){
			first=el.next;
			return true;
		}
		if(index==size()-1){
			ListNode prev = get(index-1);
			last=prev;
			prev.next=null;
			return true;
		}
		ListNode prev=get(index-1);
		ListNode next = el.next;
		prev.next=next;
		return true;
	}
	
	
	/**
	 *  This method should return the index of the FIRST occurrence of the 
	 *  given element, OR -1 if the element is not found in the list.
	 * 
	 */
	@Override
	public int indexOf(Integer element) {
		ListNode e = first;
		int index=0;
		while(e!=null){
			if(e.element==element){
				return index;
			}
			e=e.next;
			index++;
		}
		return -1;
	}

	
	/**
	 * Replaces the element at the given index with the new element.
	 * RETURNS the OLD element.
	 * 
	 * The method should throw an IndexOutOfBoundsException if an invalid index is 
	 * provided.
	 */
	@Override
	public Integer set(int index, Integer element) throws IndexOutOfBoundsException {
		if(index<0||index>size()-1){
			throw new IndexOutOfBoundsException();
		}
		ListNode e = get(index);
		int old = e.getElement();
		e.element=element;
		return old;
	}
}
