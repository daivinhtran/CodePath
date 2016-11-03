import java.util.*;
public class HashTableWordCount {
	public static void main(String[] args) {
		HashMap<String, Integer> wordMap = wordCount("To be or not to be, that is the question");
		System.out.println(wordMap);
		Map<Integer, HashSet<String>> invertMap = invertMap(wordMap);
		System.out.println(invertMap);

	}
	public static HashMap<String, Integer> wordCount(String string) {
		String[] words = string.split("\\W");
		HashMap<String, Integer> wordMap = new HashMap<>();
		for (String word : words) {
			word = word.trim().toLowerCase();
			if (word.length()==0) continue;
			if (!wordMap.containsKey(word))
				wordMap.put(word,0);
			wordMap.put(word, wordMap.get(word)+1);
		}
		return wordMap;
	}
	public static Map<Integer, HashSet<String>> invertMap(HashMap<String, Integer> map) {
		Map<Integer, HashSet<String>> multimap = new HashMap<Integer, HashSet<String>>();
		for (String word : map.keySet()) {
			int val = map.get(word);
			if (!multimap.containsKey(val))
				multimap.put(val, new HashSet<String>());
			multimap.get(val).add(word);
		}
		return multimap;

	}
}