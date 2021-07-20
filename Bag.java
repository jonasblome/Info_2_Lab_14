import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Bag {
	private HashSet<String> substrings;
	
	public Bag (String word) {
		substrings = generateSubstrings(word);
	}
	
	public HashSet<String> getSubstrings () {
		return substrings;
	}
	
	private HashSet<String> generateSubstrings(String word) {
		HashSet<String> subs = new HashSet<String>();
		
		subs = generateSubstring(subs, word);
		
		return subs;
	}
	
	private HashSet<String> generateSubstring (HashSet<String> list, String word) {
		if (word.length() < 3) {
			list.add(word);
			return list;
		}
		
		char[] chars = word.toCharArray();
        Arrays.sort(chars);
		list.add(word);
		
		for(int i = 0; i < word.length(); i++) {
			String substring = word.substring(0, i) + word.substring(i + 1);
			generateSubstring(list, substring);
		}
		
		return list;
	}
}