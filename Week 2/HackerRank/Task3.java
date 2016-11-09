import java.util.*;
public class Task3 {
	public static void main(String[] args) {
		String s = "He had -nonsense- quite enough of this nonsense!";
		System.out.println(firstRepeatedWord(s));
	}
	static String firstRepeatedWord(String s) {
		String[] words = s.split("\\W");
		System.out.println(Arrays.toString(words));
		HashSet<String> appeared = new HashSet<>();
		for (String word : words)
			if (appeared.contains(word.trim()) )
				return word.trim();
			else {
				if (word.trim().length()>0)
				appeared.add(word.trim());
			}
		return "la";

    }


}