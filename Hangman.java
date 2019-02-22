/*
Hangman game (Java)
22 February 2019
Niall Stapleton
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Hangman
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String word = Word.getRandomWord().toUpperCase();
		int guessLimit = 10;
		String letters = "";
		List<Character> guessedLetters = new ArrayList<Character>();

		System.out.println("The word is:");
		System.out.println(Word.showLetters(word, letters));

		while(!Word.allDone(word, letters) && guessLimit > 0) {

			System.out.println("Guess a letter:");
			// Avoids issues with case sensitivity
			char guess = Character.toUpperCase(in.next().charAt(0));
			
			if(guessedLetters.contains(guess)) {
				System.out.println("You already guessed this letter!");
			}

			if(!Word.containsLetter(word, guess) && !guessedLetters.contains(guess)) {
				guessLimit--;
				System.out.println("Not a letter! " + guessLimit + " lives remaining.");
			}
				
			if(!guessedLetters.contains(guess)) {
				guessedLetters.add(guess);
			}
			
			letters += String.valueOf(guess);
			System.out.println(Word.showLetters(word, letters));
			System.out.println();
		}

		if(guessLimit > 0) {
			System.out.println("Well done, the word was " + word + ".");
		}
		else {	
			System.out.println("Sorry, you lose! The word was " + word + ".");
		}
	}
}