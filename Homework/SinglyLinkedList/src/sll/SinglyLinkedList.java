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

		//create new node
		ListNode n = new ListNode(element);

		//if this is the first node, set first and last to the new node and return
		if(size()==0){
			last=n;
			first=n;
			return;
		}

		//if it is not the first node, tack the first node onto the end
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

		//loop through list while counting
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

		//error handling
		if (size()!=0 && index>size()){
			throw new IndexOutOfBoundsException();
		}

		//if the index is 0, add the new node to the beginning
		if(index==0){

			//make new node
			ListNode n = new ListNode(element);

			//if this is the only node, set last to this node
			if(last==null){
				last=n;
			}
			//set first to the new node and return
			n.next=first;
			first=n;
			return;
		}

		//if index is the end of the list use add func and return
		if(index>=size()){
			add(element);
			return;
		}

		//loop till we find the node before the index we want
		int count = 0;
		ListNode e = first;
		while(count<index-1&&e!=null){
			count++;
			e=e.next;
		}

		//if the node is not null, insert a new node
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

	/**
	 * NOT PART OF PROJECT, I ADDED IT TO MAKE MY LIFE EASIER
	 * Returns the node at the index
	 * @param index the index of the node to get
	 * @return The node at the given index
	 * @throws IndexOutOfBoundsException
	 */
	public ListNode get(int index)throws IndexOutOfBoundsException{

		//if index is out of bounds, throw error
		if(index>=size()){
			throw new IndexOutOfBoundsException();
		}

		//loop till we get to the index we want
		int curIndex=0;
		ListNode e = first;
		while(e!=null){

			// when we get to the index, return
			if(curIndex==index){
				return e;
			}

			//if we are not at the index we want yet, increment variables
			curIndex++;
			e=e.next;
		}

		//if node is not found, throw error
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

		//get the index of the element to remove
		int index= indexOf(element);

		//if the index is not found, return false
		if(index==-1){
			return false;
		}

		//assuming the node does exist get it
		ListNode el = get(index);

		//if this is the only node, remove it by wiping it from first and last
		if(size()==1){
			last=null;
			first=null;
			return true;
		}

		//if we are removing the beginning node, remove it by setting first to the next node
		if(index==0){
			first=el.next;
			return true;
		}

		//if the node is the last one, do the same as if index were 0 but at the end, return
		if(index==size()-1){
			ListNode prev = get(index-1);
			last=prev;
			prev.next=null;
			return true;
		}

		//if we are still in the func, assume then node is somewhere in the middle, pop it out of the list
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

		//loop till e is null
		while(e!=null){

			// if we found the element return counter
			if(e.element==element){
				return index;
			}
			e=e.next;
			index++;
		}

		//if we can't find it, return -1
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

		//error handling
		if(index<0||index>size()-1){
			throw new IndexOutOfBoundsException();
		}

		//get the node at the index, and change it, while storing the old value
		ListNode e = get(index);
		int old = e.getElement();
		e.element=element;
		return old;
	}
}
