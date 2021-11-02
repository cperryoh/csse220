package sllAlgorithms;

import sll.ILinkedList;
import sll.IListNode;
import sll.ListNode;
import sll.SinglyLinkedList;

// TODO: complete sll.SinglyLinkedList first, then use it to complete these problems.
public class Algorithms {

	/**
	 * 
	 * Write a function that takes an incoming array of integers and returns a linked
	 * list. The linked list should contain only the integers in the original
	 * list that begin with the number 1.
	 * 
	 * So arraylistOf1s({123,456,1, 21}) yields [123, 1]
	 */
	public static SinglyLinkedList arraylistOf1s(int[] incomingA) {

		//make new list
		SinglyLinkedList s = new SinglyLinkedList();

		//loop through array
		for(int i :incomingA){

			//convert number to string
			String num = Integer.toString(i);

			//check first char, if it is a 1, add it to the list
			if(num.charAt(0)=='1'){
				s.add(i);
			}
		}

		//return the list
		return s;
	} // arraylistOf1s

	/**
	 * Takes a list of numbers in sorted (ascending) order and a number to add.
	 * 
	 * Adds the number in the correct place in the sorted list.
	 * 
	 * so insertIntoSorted([1,5,9],6) yields [1,5,6,9]
	 * 
	 */
	public static void insertIntoSorted(ILinkedList list, int numberToAdd) {
		IListNode e =list.getFirst();
		int index=0;

		//loop till we get to the end of the list
		while (e!=null){

			//if the element is bigger than the new number, inset at index and return
			if(e.getElement()>numberToAdd){
				list.insertAtIndex(index,numberToAdd);
				return;
			}
			e=e.getNext();
			index++;
		}

		//add it to the end if we cant find a number bigger than the one to add
		list.add(numberToAdd);
	} // insertIntoSorted

	/**
	 * Takes an incoming linked list and removes all numbers longer than 3 digits from the
	 * list.
	 * 
	 * So removeLongNumbers([1,1000,3,99999,999]) yields [1, 3, 999]
	 */
	public static void removeLongNumbers(ILinkedList incomingList) {

		//loop through list
		IListNode e = incomingList.getFirst();
		while (e!=null){

			//convert number to a string
			String num = Integer.toString(e.getElement());

			//only remove it if the length is greater than 3
			if(num.length()>3){
				incomingList.remove(e.getElement());
			}

			//move on
			e=e.getNext();
		}
	} // removeLongNumbers

	/**
	 * Returns whether the given incoming linked list is sorted in increasing order.
	 * 
	 * So checkSorted([1,2,3]) yields true.
	 * checkSorted ([1,3,2]) yields false.
	 * checkSorted ([]) yields true.
	 */
	public static boolean checkSorted(ILinkedList incomingList) {
		IListNode e = incomingList.getFirst();

		//loop through list
		while (e!=null){

			//if e next is not null compare cur node and next if they are in the correct order
			if(e.getNext()!=null){
				if(e.getNext().getElement()<e.getElement()){

					//if not return false
					return false;
				}
			}
			e=e.getNext();
		}

		//if it is sorted return true
		return true;
	} // checkSorted

	/**
	 * Duplicates all elements of the incoming linked list.
	 * 
	 * So doubleList([1, 2, 3]) yields [1, 1, 2, 2, 3, 3].
	 */
	public static void doubleList(ILinkedList incomingList) {
		IListNode e = incomingList.getFirst();
		int index = 0;

		//loop
		while(e!=null){

			//insert duplicate of cur node
			incomingList.insertAtIndex(index+1,e.getElement());

			//move onto next node, past then one we just added
			index+=2;

			//get the node after the next
			e=e.getNext().getNext();
		}
	} // doubleList

	/**
	 * Returns whether the incoming linked list stores the values of a valid Fibonacci sequence.
	 * 
	 * Recall: fib(i) = fib(i-1) + fib(i-2)
	 * 
	 * [0,1] is too short to be a fibonacci sequence. [1,2,3] is a fibonacci
	 * sequence because 3 = 2 + 1. [0,1,1] is a fibonacci sequence because 1 = 1
	 * + 0. [1,4,5,9,14] is a fibonacci sequence.
	 */
	public static boolean isFibonacciSequence(ILinkedList incomingList) {

		//if the list size is less than 3, it cant work, return false
		if(incomingList.size()<3){
			return false;
		}

		//store the past two numbers
		Integer prev1=null;
		Integer prev2=null;

		IListNode e = incomingList.getFirst();

		//loop
		while (e!=null){

			//check to make sure both of our prev vars are not null
			if(prev1!=null&&prev2!=null){

				//does the cur element equal to the sum of the two prev numbers
				if(e.getElement()!=prev1+prev2){
					//if not, return false
					return false;
				}
			}

			//move prev1 to prev 2
			prev2=prev1;

			//set prev1 to current node value
			prev1=e.getElement();

			//move on
			e=e.getNext();
		}
		return true;
	} // isFibonacciSequence

	/**
	 * Gets the value of the ith node.
	 * 
	 * If i==0, return the value of the given node.
	 * 
	 * If you are passed an invalid index you should throw an IndexOutOfBoundsException.
	 * 
	 */
	public static Integer recursiveGet(int index, IListNode iListNode) {

		//error handling
		if(index<0)
			throw new IndexOutOfBoundsException();

		//if index==0, return value
		if(index==0){

			//if we get a NullPointerException, assume index did not exist and return null
			try{
				return iListNode.getElement();
			}catch (NullPointerException e){
				throw new IndexOutOfBoundsException();
			}
		}

		//move onto the next node, stepping index down 1
		return recursiveGet(index-1,iListNode.getNext());
	} // recursiveGet

}
