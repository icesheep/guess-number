/**
 * An Array-based implementation of the Guess-A-Number game
 */

public class ArrayGame {

 // stores the next number to guess
 private int guess;
 private int[] guesses = new int[100];
 private int[] guessesMatches = new int[100];
 private boolean[] all = new boolean[9999];
 private int cursor = 0;
 private boolean flag = false;
 // TODO: declare additional data members, such as arrays that store
 // prior guesses, eliminated candidates etc.

 // NOTE: only primitive type arrays are allowed, such as int[], boolean[] etc.
 // You MAY NOT use any Collection type (such as ArrayList) provided by Java.
 
 /********************************************************
  * NOTE: you are allowed to add new methods if necessary,
  * but DO NOT remove any provided method.
  *******************************************************/
 
 
 // ArrayGame constructor method
 public ArrayGame() {
  reset();
 }
 
 
 // Resets data members and game state so we can play again
 public void reset() {
  guess = 1000;
  for(int i = 1000; i < 9999; i++) {
	  all[i] = false;
  }
  //TODO: initialize all other data members 
 }
 
 
 
 // Returns the number of guesses so far.
 public int numGuesses() {
 //TODO: get the number of guesses taken so far
	 return cursor+1;
 }
  
 /**
  * Returns the number of matches between integers a and b.
  * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
  * The return value must be between 0 and 4.
  * 
  * A match is the same digit at the same location. For example:
  *   1234 and 4321 have 0 match;
  *   1234 and 1114 have 2 matches (1 and 4);
  *   1000 and 9000 have 3 matches (three 0's).
  */
 public static int numMatches(int a, int b) { 
 //TODO: find the number of mathes between two integers
	 int i = 0;
	 if(a%10 == b%10) {
		 i++;
	 }
	 if(a%100/10 == b%100/10) {
		 i++;
	 }
	 if(a%1000/100 == b%1000/100) {
		 i++;
	 }
	 if(a%10000/1000 == b%10000/1000) {
		 i++;
	 }
	 return i;
 }
 
 
 /**
  * Returns true if the game is over; false otherwise.
  * The game is over if the number has been correctly guessed
  * (i.e. if all candidates have been eliminated.)
  */
 public boolean isOver() {
 //TODO: check if all candidates are eliminated
	 return flag;
 }
 
 
 /**
  * Returns the next guess number and adds it to the list of prior guesses.
  * TODO: add guess to the list of prior guesses.
  */
 public int getGuess() {
	 return guess;

 }
 
 
 /**
  * Eliminates more candidates based on the number of matches of the previous guess.
  * TODO: If nmatches is 4, the previous guess is correct and the game is over.
  * If not, the candidates are eliminated as explained in the project description.
  * 
  * Returns true if the update has no error; false if all candidates
  * have been eliminated (indicating a state of error);
  */
 public boolean updateGuessing(int nmatches) {
	 guesses[cursor] = guess;
	 guessesMatches[cursor] = nmatches;
	 if(nmatches == 4) {
		 flag = true;
		 return true;
	 }
	 if(nmatches == 0) {
		 for(int i = 1000; i < 9999; i++) {
			 if(i%10 == guess%10 || i%100/10 == guess%100/10 || i%1000/100 == guess%1000/100 || i%10000/1000 == guess%10000/1000) {
				 all[i] = true;
			 }
		 }
	 }else {
		 all[guess] = true;
		 if(cursor > 0) {
			 int diff = guesses[cursor] - guesses[cursor-1]; 
			 int matchDiff = guessesMatches[cursor] - guessesMatches[cursor-1]; 
			 String temp = String.valueOf(diff);
			 int sureNumberLength = temp.length();
			 if(guessesMatches[cursor-1] > 0) {
				 if(matchDiff > 0) {
					 for(int i = 1000; i < 9999; i++) {
						 if(i%Math.pow(10,sureNumberLength)/Math.pow(10,sureNumberLength-1) != guesses[cursor]%Math.pow(10,sureNumberLength)/Math.pow(10,sureNumberLength-1)) {
							 all[i] = true;
						 }
					 }
				 }else if(matchDiff < 0){
					 for(int i = 1000; i < 9999; i++) {
						 if(i%Math.pow(10,sureNumberLength)/Math.pow(10,sureNumberLength-1) != guesses[cursor-1]%Math.pow(10,sureNumberLength)/Math.pow(10,sureNumberLength-1)) {
							 all[i] = true;
						 }
					 }
				 }
			 }
		 }
	 }
	 cursor++;
	 for(int i = 1000; i < 9999; i++) {
		 if(all[i]) {
			 
		 }else {
			 guess = i;
			 return true;
		 }
	 }
	 return false;
 
 }
 
 /** 
 * Returns the list of guesses so far as an integer array.
 * The size of the array must be the number of prior guesses.
 * Returns null if there has been no prior guess
 */
 public int[] priorGuesses() {
   int[] temp = new int[cursor+1];
   System.arraycopy(guesses, 0, temp, 0, cursor+1); 
   return temp;
 }
}
