import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * A dictionary of calculated hash values.
 * Takes a list of words, generates their hashes and
 * checks for collisions.
 * 
 * @author n-c0de-r
 * @author jonasblome
 * @author GitYusuf
 * @version 17.07.2021
 */
public class Dictionary {
	private final int HASH_MULTIPLIER;
	public ArrayList<LinkedList<String>> wordHashes;
	
	/**
	 * Constructor of dictionary class.
	 */
	public Dictionary() {
		GeneratePrimes p = new GeneratePrimes();
		HASH_MULTIPLIER = p.generatePrime();
		setupDictionary();
	}

	/**
	 * Generate a new dictionary with hash values.
	 * @throws IOException 
	 */
	private void setupDictionary() {
		int collisions = 0;
		
		WordParser w = new WordParser();
		ArrayList<String> words = w.getWords();

		wordHashes = new ArrayList<>();
		
		//Set the size array list to half the length of available words.
		for (int i = 0; i < words.size(); i++) {
			wordHashes.add(i, null);
		}
		
		//Longest chain counter
		int longestChain = 0;
		
		for (String word : words) {		
			// Generate hash values and set as current index
			int index = generateHash(word);
//			LinkedList<String> currentList = wordHashes.get(index);
			
			// Check if the word is already in the LinkedList
            if (wordHashes.get(index) == null) {
            	wordHashes.set(index, new LinkedList<String>());
            } else {
                collisions++;
            }
            
            int currentChainLength = 0;
            
            // Assign the words to the list at the position of hash values
            wordHashes.get(index).add(word);
			
            currentChainLength = wordHashes.get(index).size();
			
			//If the newly found chain is longer, update the value
			if (currentChainLength > longestChain) {
				longestChain = currentChainLength;
			}

		}
		System.out.println("There are " + wordHashes.size() + " entries in the table.\n");
		System.out.println("There are " + collisions + " collisions in the table.\n");
		System.out.println("Longest chain is " + longestChain +"\n");
	}
	
	//Helper Methods start here
	
	/**
	 * Helper method to generate a word's hash value.
	 * 
	 * @param word	Word to calculate the has for.
	 * @return		The integer hash value.
	 */
	private int generateHash(String word) {
		//Normalize the word
		word = word.toUpperCase();
		char[] chars = word.toCharArray();
        Arrays.sort(chars);
        
		long hash = 0;
		
		for (int i = 0; i < chars.length; i++) {
			hash = HASH_MULTIPLIER * hash + chars[i];
		}
		
		hash = Math.abs(hash % wordHashes.size());
		return (int) hash;
	}
	
	/**
	 * Generate a hash of any given word.
	 * 
	 * @param inputWord	The word to generate hash for.
	 * @return	Hash value.
	 */
	private LinkedList<String> getWords(String inputWord) {
		//Generate the word's hash value as an index
		int hash = generateHash(inputWord);
		
		//Return the found list.
		return wordHashes.get(hash);
	}
	
	/**
	 * Find all permutations of a given word.
	 * 
	 * @param word	Word to be found.
	 */
	public String checkPermutations(String word) {	
		//Get the list containing the search word
		LinkedList<String> list = getWords(word);
		System.out.println("Found the word: \"" + word + "\" in list: \n" + list);
		
		ArrayList<String> perms = new ArrayList<>();
		
		//Look for permutations of the word and print the result
		for (String element : list) {
			if (isPermutation(element, word)) {
				perms.add(element);
			}
		}
		System.out.println("\nThe permutations of \"" + word + "\" are:");
		return perms.toString();
	}
	
	/**
	 * Compare, if two words are true permutations of each other.
	 * 
	 * @param listWord	First word
	 * @param inputWord	Second word
	 * @return		Results true if they are REALLY permutable
	 */
	private boolean isPermutation(String listWord, String inputWord) {
		//Normalize the word
		listWord = listWord.toUpperCase();
		inputWord = inputWord.toUpperCase();
		
		char[] chars1 = listWord.toCharArray();
		char[] chars2 = inputWord.toCharArray();
		
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
       listWord = new String(chars1);
       inputWord = new String(chars2);
       
       if (listWord.equals(inputWord)) {
    	   return true;
       }
       return false;
	}
}
