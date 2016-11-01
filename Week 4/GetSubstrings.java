import java.util.*;
public class GetSubstrings {
	static List getSubstrings(String s) {
		ArrayList<String> substrings = new ArrayList<>();
		for (int i=0; i < s.length();i++) {
			String temp = "";
			for (int j=i; j<s.length();j++) {
				temp = temp + s.charAt(j);
				substrings.add(temp);
			}
		}
		return substrings;
	}	
	static List<String> getSubstringsRecursion(String s) {
		ArrayList<String> temp = new ArrayList<>();
		for (int i=0; i<s.length();i++) {
			String current = s.charAt(i) + "";
			temp.add(current);
			getSubstringsRecursion(s, current, i+1, temp);
		}
		return temp;
	} 
	static void getSubstringsRecursion(String s, String current, int index, List<String> temp) {
		if (index<s.length()) {
			current = current + s.charAt(index);
			temp.add(current);
			getSubstringsRecursion(s, current, index+1, temp);
		}
	}
	public static void main(String[] args) {
		System.out.println(getSubstringsRecursion("12345"));
	}
}