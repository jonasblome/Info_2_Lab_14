import java.util.Scanner;

/**
 * Main runner class of the Scrabble Cheater app.
 * Sets up a dictionary of allowed words in Scrabble.
 * Takes scrambled inputs and finds viable words of it.
 * 
 * @author	n-c0de-r
 * @author	jonasblome
 * @author	GitYusuf
 * @version	17.07.2021
 */
public class ScrabbleCheater {

	public static void main(String[] args) {
		ScrabbleCheater cheater = new ScrabbleCheater();
		Dictionary dict = new Dictionary();
		
		System.out.println(dict.checkPermutations("sgesals") + "\n");
		
		System.out.println("--------------------");
		
		cheater.findWord(dict);
	}
	
	/**
	 * Takes inputs from users and searches for it in the dictionary.
	 */
	private void findWord(Dictionary dict) {
		Scanner s = new Scanner(System.in);
		String word = "";
		
		System.out.println("Type in a 7 character word, to find it's permutations to cheat.\n"
				+ "Type 'quit' or hit the Q button when you are finished.\\n");
		
		while (!word.toLowerCase().equals("quit") || !word.toLowerCase().equals("q")) {
			System.out.print("Input here: ");
			word = s.nextLine();
			if (word.length() != 7) {
				System.out.println("\nPlease type in exactly 7 characters.");
				break;
			}
			System.out.println(dict.checkPermutations(word) + "\n");
		}
		s.close();
	}
}
