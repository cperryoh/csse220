package Homework2DArrays;

import java.awt.desktop.AboutHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.junit.experimental.theories.DataPoint;

/**
 * Class: Homework2DArrays
 * 
 * @author CSSE Faculty Purpose: provide practice with 2D arrays
 * 
 */
public class Homework2DArrays {

	/**
	 * 
	 * Given a square array, determines if it is diagonal That is, returns true if
	 * all values in the array are 0 except the main diagonal. The main diagonal is
	 * entries of the form data[i][j] where i == j. Elements on the main diagonal
	 * can be 0 or any other number.
	 * 
	 * Examples: {{1,0,0}, {0,2,0} {0,0,3}} yields true
	 * 
	 * {{1,0,9}, {0,2,0}, {0,0,3}} yields false because 0,2 is nonzero
	 * 
	 * {{0,0,0}, {0,0,0}, {0,0,3}} yields true because there can be 0 entries on the
	 * diagonal if desired
	 * 
	 * @param data input array
	 * @return true if it is diagonal, false otherwise
	 */
	public static boolean isDiagonal(int[][] data) {
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data.length; y++) {
				if (x != y && data[x][y] != 0) {
					return false;
				}
			}
		}
		return true;
	} // isDiagonal

	/**
	 * 
	 * Given a 2D array populated with a sequence of characters that wrap from the
	 * rightmost position to the leftmost position on the next row, find the length
	 * of the longest sequence of repeated characters.
	 * 
	 * For example
	 * 
	 * abba dafa
	 * 
	 * Has a longest sequence of 2 for the 2 repeated bs
	 * 
	 * 2 Bs yield the longest repeat sequence here. Note that the As do not follow
	 * after each other and hence, do not get considered.
	 * 
	 * The array is considered to "wrap" from the rightmost position to the leftmost
	 * position on the next line.
	 * 
	 * For example:
	 * 
	 * abcdd ddefg
	 * 
	 * Is considered to have a longest sequence of 4 because the two ds on the right
	 * "wrap around" to connect with the two ds on the next line
	 * 
	 * @param data
	 * @return the length of the longest sequence
	 */
	public static int longestRepeatSequence(char[][] data) {
		// flatten the array
		ArrayList<Character> chars = new ArrayList<Character>(0);
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[0].length; x++) {
				chars.add(data[y][x]);
			}
		}
		char last=' ';
		int streakCounter=1;
		ArrayList<Integer> streaks =  new ArrayList<Integer>(0);
		for (char chr : chars) {
			if(chr==last) {
				streakCounter++;
			}
			if(chr!=last&&streakCounter!=0) {
				streaks.add(streakCounter);
				streakCounter=1;
			}
			last=chr;
		}
		streaks.add(streakCounter);
		int longest = 0;
		for (int streak : streaks) {
			if(longest<streak) {
				longest=streak;
			}
		}

		return longest;
	}
	public static void main(String[] args) {
		char[][] foo = {{'a','b','c'},{'d','d','e'}};
		System.out.println(longestRepeatSequence(foo));
	}
	// longestRepeatSequence
	/**
	 * Given a 2D array of characters, returns a string consisting of all the
	 * characters in column-order, that is, one column at a time, going from left to
	 * right.
	 * 
	 * For example,
	 * 
	 * hlo el!
	 * 
	 * returns the string "hello!"
	 * 
	 * @param data rectangular 2D array.
	 * @return a single string made of all the characters in each column.
	 */
	public static String stringFromColumns(char[][] data) {
		String out = "";
		for (int i = 0; i < data[0].length; i++) {
			for (int a = 0; a < data.length; a++) {
				out += data[a][i];
			}
		}
		return out;
	} // stringFromColumns

	/**
	 * Given A specific starting position and distance returns a 10x10 character
	 * array with all positions that are less than or equal to that manhattan
	 * distance from the starting position marked with an x.
	 * 
	 * Recall the manhattan distance is the distance in terms of number of direct
	 * steps North South East West.
	 *
	 * You can compute the manhanttan distance with this formula distance = |x1 -
	 * x2| + |y1 - y2|
	 * 
	 * Unmarked cells should be filled with a period '.'
	 * 
	 * For example, given row=1,col=1,distance 1 .x........ xxx....... .x........
	 * .......... .......... .......... .......... .......... .......... ..........
	 * ..........
	 * 
	 * For example, given row=1,col=6,distance 2 .....xxx.. ....xxxxx. .....xxx..
	 * ......x... .......... .......... .......... .......... .......... ..........
	 * ..........
	 * 
	 * 
	 * @param row      starting position row
	 * @param col      starting position col
	 * @param distance
	 * @return new 10x10 char array with correct squares marked
	 */
	public static char[][] distanceArray(int row, int col, int distance) {
		char[][] arr = new char[10][10];
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[0].length; x++) {
				int curDis = Math.abs(y - row) + Math.abs(x - col);
				
				if (curDis <= distance) {
					arr[y][x]='x';
				} 
				else {
					arr[y][x]='.';
				}
			}
		}
		return arr;
	}
	// distanceArray

	// ***********************************************************************************************
	// BONUS: Extra credit problem
	// ***********************************************************************************************

	/**
	 * 
	 * Feel free to skip this one if you don't have time. It's a little harder.
	 * 
	 * You are given a map indicating the elevation of a small area like a desk. A
	 * ball is placed on the desk. The ball will roll downhill going north south
	 * east or west.
	 *
	 * The ball always starts at position 1,1
	 *
	 * It will always choose the path of steepest descent. It will eventually come
	 * to rest when it is at a position where all neighboring positions are
	 * higher/equal. Return the elevation of that position.
	 * 
	 * You can assume that map will be such that the ball will always come to rest
	 * without moving through an edge
	 * 
	 * You can assume there will always be one steepest position for the ball to go
	 * to
	 * 
	 * For example, in an array like this: 9999 9549 9999 yields 4 The ball would
	 * start in 1,1 (5) rolls to 4 and stops
	 * 
	 * 99999999999 
	 * 98711111199 
	 * 96999999999 
	 * 95444444399 
	 * 99999999999 yields 4 The ball
	 * starts at 8, follows steepest decent to 6 Then at the first 4 there is no
	 * lower position so it stops
	 * 
	 * @param map map indicating elevation
	 * @return height where the ball stops
	 */
	public static int ballRestElevation(int[][] map) {
		int x=1,y=1;
		int lowestVal = 100;
		while (true) {
			// search near by
			int lowestX=100;
			int lowestY=100;
			for (int x_ = -1; x_ <= 1; x_++) {
				for (int y_ = -1; y_ <= 1; y_++) {
					int checkX = x_ + x;
					int checkY = y_ + y;
					//not diagonal but still check current square against surrounding squares
					boolean isValidCoords=Math.abs(x_)!=Math.abs(y_)||(x_==0&&y_==0);
					
					if (isInBounds(checkX, checkY, map)&& isValidCoords) {
						if (map[checkY][checkX] < lowestVal) {
							lowestVal = map[checkY][checkX];
							lowestX=checkX;
							lowestY=checkY;
						}
					}
				}
			}
			if(lowestVal==map[y][x]) {
				return lowestVal;
			}
			x=lowestX;
			y=lowestY;
			System.out.println("");
		}
	} // ballRestElevation

	public static boolean isInBounds(int x, int y, int[][] arr) {
		try {
			int temp = arr[y][x];
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

}
