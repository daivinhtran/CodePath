import java.util.*;
public class HashTableWordCount {
	public static void main(String[] args) {
		System.out.println(wordCount("To be or not to be, that is the question"));
	}
	public static Map<String, Integer> wordCount(String string) {
		String[] words = string.split("\\W");
		Map<String, Integer> wordMap = new HashMap<>();
		for (String word : words) {
			word = word.trim().toLowerCase();
			if (word.length()==0) continue;
			if (!wordMap.containsKey(word))
				wordMap.put(word,0);
			wordMap.put(word, wordMap.get(word)+1);
		}
		return wordMap;
	}
}