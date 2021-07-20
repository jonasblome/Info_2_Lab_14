import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to generate a list of Scrabble words from a file.
 * 
 * @author	n-c0de-r
 * @author	jonasblome
 * @author	GitYusuf
 * @version	17.07.2021
 */
public class WordParser {

	/**
	 * Method to create the list of Scrabble words.
	 * 
	 * @return	ArrayList of names.
	 */
	public ArrayList<String> getWords(int wordLength) {
		ArrayList<String> w = new ArrayList<>();
		
		File f = new File ("./scrabble.txt");
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				//Only get 7 letter words, task 3
				String word = s.nextLine();
				if (word.length() == wordLength) {
					w.add(word);
				}
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return w;
	}
}