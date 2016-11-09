/*input
5
aaabbb
ab
abc
mnop
xyyx
*/
import java.util.*;
public class Task1 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test = scan.nextInt();
		scan.nextLine();
		for (int t = 0; t < test; t++) {
			String line = scan.nextLine().trim();
			int len = line.length();
			if (len % 2 !=0) {
				System.out.println(-1);
			}
			else {
				HashMap<Character, Integer> mapA = new HashMap<>();
				for (int i = 0; i < len / 2 + len % 2; i++) {
					char character = line.charAt(i);
					if (!mapA.containsKey(character))
						mapA.put(character, 0);
					mapA.put(character, mapA.get(character)+1);
				}
				HashMap<Character, Integer> mapB = new HashMap<>();
				for (int i = len / 2 + len % 2; i < len; i++) {
					char character = line.charAt(i);
					if (!mapB.containsKey(character))
						mapB.put(character, 0);
					mapB.put(character, mapB.get(character)+1);
				}
				int change = 0;
				for (Character ch : mapA.keySet()) {
					if (mapB.containsKey(ch))
						change += mapA.get(ch)-Math.min(mapA.get(ch),mapB.get(ch));
					else	
						change += mapA.get(ch);
				}
				System.out.println(change);

			}

		}
	}

}