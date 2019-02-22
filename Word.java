public class Word
{
	public static boolean containsLetter(String word, char letter)
	{
		for(int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter)
				return true;
		}
		return false;
	}

	public static String showLetters(String word, String guesses)
	{
		String locations = "";
		for(int i = 0; i < word.length(); i++) {
			if(containsLetter(guesses, word.charAt(i))) {
				locations += word.charAt(i);
			}
			else {
				locations += "_";
			}
		}
		return locations;
	}

	public static boolean allDone(String word, String guesses)
	{
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			if(containsLetter(guesses, word.charAt(i))) {
				count++;
			}
		}

		// Ignores whitespace
		word = word.replaceAll("\\s+", "");
		if(count == word.length()) {
			return true;
		}
		return false;
	}

	public static String getRandomWord()
	{
		String [] words = {
				"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
				"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
				"Illinois", "Indiana", "Iowa", "Kentucky", "Louisiana", "Maine",
				"Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
				"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
				"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
				"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
				"Washington", "West Virginia", "Wisconsin", "Wyoming"
				};

		int randomIndex = (int) (Math.random() * words.length);
		return words[randomIndex];
	}

}