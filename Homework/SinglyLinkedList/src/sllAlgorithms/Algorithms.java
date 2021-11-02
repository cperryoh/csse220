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
		SinglyLinkedList s = new SinglyLinkedList();
		for(int i :incomingA){
			String num = Integer.toString(i);
			if(num.charAt(0)=='1'){
				s.add(i);
			}
		}
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
		while (e!=null){
			if(e.getElement()>numberToAdd){
				list.insertAtIndex(index,numberToAdd);
				return;
			}
			e=e.getNext();
			index++;
		}
		list.add(numberToAdd);
	} // insertIntoSorted

	/**
	 * Takes an incoming linked list and removes all numbers longer than 3 digits from the
	 * list.
	 * 
	 * So removeLongNumbers([1,1000,3,99999,999]) yields [1, 3, 999]
	 */
	public static void removeLongNumbers(ILinkedList incomingList) {
		IListNode e = incomingList.getFirst();
		while (e!=null){
			String num = Integer.toString(e.getElement());
			if(num.length()>3){
				incomingList.remove(e.getElement());
			}
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
		if(incomingList.size()==0){
			return true;
		}
		while (e!=null){
			if(e.getNext()!=null){
				if(e.getNext().getElement()<e.getElement()){
					return false;
				}
			}
			e=e.getNext();
		}
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
		while(e!=null){
			incomingList.insertAtIndex(index+1,e.getElement());
			index+=2;
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
		if(incomingList.size()<3){
			return false;
		}
		Integer prev1=null;
		Integer prev2=null;
		IListNode e = incomingList.getFirst();
		while (e!=null){
			if(prev1!=null&&prev2!=null){
				if(e.getElement()!=prev1+prev2){
					return false;
				}
			}
			prev2=prev1;
			prev1=e.getElement();
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
		if(index<0)
			throw new IndexOutOfBoundsException();
		if(index==0){
			try{
				return iListNode.getElement();
			}catch (NullPointerException e){
				throw new IndexOutOfBoundsException();
			}
		}
		return recursiveGet(index-1,iListNode.getNext());
	} // recursiveGet

}
