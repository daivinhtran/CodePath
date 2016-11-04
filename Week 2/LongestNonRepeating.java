import java.util.*;
public class LongestNonRepeating {
	public static void main(String[] args) {
		String test = "abcabcbb";
		System.out.println(findLongest(test));
	}
	public static int findLongest(String string) {
		HashMap<Character, Integer> map = new HashMap<>();
		int len = string.length();
		int max = 0;
		int lastRepeated = -1;
		for (int i = 0; i < len; i++) {
			char character = string.charAt(i);
			if (map.containsKey(character)) {
				int lastAppear = map.get(character);
				int startIndex = Math.max(lastAppear, lastRepeated);
				max = Math.max(max, i - startIndex);
				lastRepeated = lastAppear;
			}
			map.put(character,i);
		}
		max = Math.max(max, len-1-lastRepeated);
		return max;

	}
}