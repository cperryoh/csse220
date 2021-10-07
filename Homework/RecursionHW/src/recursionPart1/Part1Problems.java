package recursionPart1;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class: Part1Problems
 * @author CSSE Faculty
 * Purpose: Provide practice implementing basic recursive operations
 *  
 */
public class Part1Problems {
	
	/**
	 * Recursive summation of one to the input value.
	 * 
	 * So for example summation(3) = 3 + 2 + 1 = 6
	 * @param value starting number for summation
	 * @return sum of 1 to the given value
	 * 
	 */
	public static int summation(int value){
		if (value==1) {
			return 1;
		}
		return value+summation(value-1);
	} // summation
	
	/**
	 * Outputs a string of 'Buffalo ' a certain number of times.
	 * 
	 * For example technicallyGramaticallyCorrect(2) returns "Buffalo Buffalo "
	 * 
	 * @param numberOfBuffalo - number of times "Buffalo " ought to be repeated
	 * @return - complete string of Buffalo
	 * 
	 */
	public static String technicallyGramaticallyCorrect(int numberOfBuffalo){
		if(numberOfBuffalo==0) {
			return "";
		}
		return "Buffalo "+technicallyGramaticallyCorrect(numberOfBuffalo-1);
	} // technicallyGramaticallyCorrect
	
	/**
	 * Removes all of the a's and b's from a string and replaces the capital C's with QQQ then returns the string.
	 * 
	 * For example the string weirdoString("aBCd") returns "BQQQd"
	 *
	 * Do NOT use the replace method on the String class! Using this method is NOT a recursive solution.
	 * 
	 * @param stringInput to do replaces/removes on
	 * @return a new string with removals and replacements
	 */
	public static String weirdoString(String stringInput){
		char c;
		
		try {
			c = stringInput.charAt(0);
			stringInput=stringInput.substring(1);
		} catch (Exception e) {
			return "";
		}
		if(c=='C') {
			return "QQQ"+weirdoString(stringInput);
		}else if(c=='a'||c=='b'){
			return weirdoString(stringInput);
		}
		else {
			return c+weirdoString(stringInput);
		}
	} // weirdoString
	
	/**
	 * Sum the elements in an arrayList.
	 * You may modify the list (e.g. remove elements).
	 * 
	 * For example arrayListSummation with the list [1, 2] would return 3
	 * @param inputList  contains numbers for summing
	 * @return sum of values in the list
	 */
	public static int arrayListSummation(ArrayList<Integer> inputList){
		int num=0;
		if(!inputList.isEmpty()) {
			num = inputList.get(0);
			inputList.remove(0);
			if(inputList.size()!=0) {
				int sum =arrayListSummation(inputList);
				return num+sum;
			}
		}
		return num;
	} // arrayListSummation
	
	/**
	 * Returns the number of threes in the prime factorization of the input value.
	 * 
	 * For example countNumberOf3sInPrimeFactorization(45) returns 2
	 * (because the prime factorization of 45 is 3*3*5)
	 * @param inputNumber used in the computation
	 * @return number of 3s in inputNumber's prime factorization
	 */
	public static int countNumberOf3sInPrimeFactorization(int inputNumber){
		if(inputNumber==0) {
			return 0;
		}
		if(inputNumber%3==0) {
			return 1+countNumberOf3sInPrimeFactorization(inputNumber/3);
		}
		else {
			return 0;
		}
	} // countNumberOf3sInPrimeFactorization
	
	/**
	 * Determine if a string of  (),  [],  {}, and  <> has matched ends.
	 * You can assume that a string always has a bunch of starting brackets, followed by a bunch
	 * of ending brackets (like this "([<>])").  You don't have to worry about strings like this
	 * "()()".  Your function should detect strings where the braces are mismatched e.g. "(]"
	 * or situations where a bracket is missing "(()" or "())"
	 * 
	 * @param inputString consisting of starting brackets and ending brackets 
	 * @return true if the braces were appropriately matched
	 * 
	 */
	static HashMap<Character, Character> bracketMap = new HashMap<Character, Character>(){{
		put('(',')');
		put('{', '}');
		put('[', ']');
		put('<', '>');
	}};
	public static void main(String[] args) {
		noDoubledLetters("works");
	}
	public static boolean bracketMatch(String inputString){
		if(inputString.length()==2) {
			return bracketMap.get(inputString.charAt(0))==inputString.charAt(1);
		}
		if(inputString.length()%2!=0) {
			return false;
		}
		if(inputString.equals("")) {
			return true;
		}
		String newStr=inputString.substring(1,inputString.length()-1);
		char open = inputString.charAt(0);
		char closed = inputString.charAt(inputString.length()-1);
		if(!bracketMap.keySet().contains(open)) {
			return false;
		}
		boolean isValid = (bracketMap.get(open)==closed);
		return isValid&&bracketMatch(newStr);
	} // bracketMatch
	
	/**
	 * Determine if a value is an even power of three (3^2, 3^4, 3^6).
	 * You can assume the input value is a power of three.
	 * 
	 * @param inputValue a power of 3
	 * @return true if the input value is an even power of 3, false otherwise
	 */
	public static boolean evenPowerOfThree(int inputValue){
		if(inputValue%3==0){
			return !evenPowerOfThree(inputValue/3);
		}
		return true;
	} // evenPowerOfThree
	
	/**
	 * Determine if there are no doubled letters in a String.
	 * 
	 * Example noDoubledLetters("abbd") returns false
	 *         noDoubledLetters("abdb") returns true
	 *         
	 * @param inputString consists of letters
	 * @return true if the string has no doubled letters, false if it has doubled letters
	 */
	public static boolean noDoubledLetters(String inputString){
		if(inputString.length()<=1) {
			return true;
		}
		String newStr = inputString.substring(1);
		boolean isDif = newStr.charAt(0)!=inputString.charAt(0);
		return isDif&&noDoubledLetters(newStr);
	} // noDoubledLetters
	
	/**
	 * Imagine a game where you're given a starting number and can repeatedly make one of two moves.
	 * You can either divide the number by three if it's divisible by three, or subtract seven.
	 * You win the game if you can reduce the number to 1.
	 * 
	 * For example, you can win with 15 because you can subtract 7 twice
	 * (you would also be allowed to divide 15 by 3, but that doesn't work for 15)
	 * 
	 * You can win with 3 because you can divide by 3.  You can win with 10 because you can
	 * subtract 7 and divide it by 3.
	 * 
	 * You can't win with 5 or 6
	 * 
	 * Write a function that returns if the game can be won with a particular starting number.
	 * @param startingNumber game staring number
	 * @return true if you can win the numbers game, false otherwise
	 */
	public static boolean numbersGame(int startingNumber){
		if(startingNumber==1) {
			return true;
		}
		if(startingNumber<1) {
			return false;
		}
		int div=0;
		int sub=0;
		if(startingNumber%3==0) {
			div=startingNumber/3;
		}
		sub=startingNumber-7;
		return numbersGame(div)||numbersGame(sub);
	} // numbersGame
} // end class Part1Problems
