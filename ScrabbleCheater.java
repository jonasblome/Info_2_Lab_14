import java.util.HashSet;
import java.util.Random;
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
	private final static int MAGIC_SCRABBLE_NUMBER = 7;
	private static Dictionary[] dictionaries;
	
	public static void main(String[] args) {
		ScrabbleCheater cheater = new ScrabbleCheater();
		dictionaries = new Dictionary[MAGIC_SCRABBLE_NUMBER + 1];
		
		for(int i = 2; i <= MAGIC_SCRABBLE_NUMBER; i++) {
			dictionaries[i] = new Dictionary(i);
		}
		
		String randomWord = cheater.randomString(MAGIC_SCRABBLE_NUMBER);
		
		Bag bag = new Bag(randomWord);
		HashSet<String> substrings = bag.getSubstrings();
		HashSet<String> foundWords = new HashSet<>();
		for(String substring : substrings) {
			int stringLength = substring.length();
			String foundWord = dictionaries[stringLength].checkPermutations(substring);
			if (foundWord != null) {
				foundWords.add(foundWord);
			}
		}
		
		System.out.println("These are the matching words for the letters " + randomWord);
		System.out.println(foundWords);
//		
//		System.out.println("--------------------");
//		
//		cheater.findWord(dict);
	}
	
	private String randomString(int letterAmount) {
		Random rand = new Random();
		String resultString = "";
		for(int i = 0; i < letterAmount; i++) {
			int random = rand.nextInt(26) + 65;
			char letter = (char)random;
			resultString += letter;
		}
		return resultString;
	}
	
	/**
	 * Takes inputs from users and searches for it in the dictionary.
	 */
	private void findWord(Dictionary dict) {
		Scanner s = new Scanner(System.in);
		String word = "";
		
		System.out.println("Type in a 7 character word, to find it's permutations to cheat.\n"
				+ "Type 'quit' or hit the Q button when you are finished.\n");
		
		boolean run = true;
		while (run) {
			System.out.print("Input here: ");
			word = s.nextLine();
			
			//Quit condition
			if (word.equals("quit") || word.equals("q")) {
				run = false;
				System.out.println("\nGood bye!");
				break;
			} else if (word.length() != 7) {
				System.out.println("\nPlease type in exactly 7 characters.");
				break;
			}
			System.out.println(dict.checkPermutations(word) + "\n");
		}
		s.close();
	}
}