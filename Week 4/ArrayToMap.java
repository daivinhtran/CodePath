import java.util.*;
public class ArrayToMap {
	static Map<Object, List> doSomething(Object[] arr) {
		Map<Object, List> map = new HashMap<>();
		Set<Integer> count = new TreeSet<>(Collections.reverseOrder());

		process(arr, map,count);
		return map;
	}
	static void process(Object[] arr, Map<Object, List> map, Set<Integer> count) {
		for (int i = 0 ; i < arr.length; i++) {
			if (arr[i] instanceof Object[]) {
				Integer countTemp = new Integer(i);
				count.add(i);
				process((Object[])arr[i], map, count);
				count.remove(i);
			}
			else
			{
				map.put(arr[i], new LinkedList());
				
				for (Integer k : count) {
					map.get(arr[i]).add(k);			
				}	
				map.get(arr[i]).add(i);			
			}
		}
	}
	public static void main(String[] args) {
		Object[] c  ={"C", "D"};
		Object[] e= {"G", "H"};
		Object[] d = {"F", e};
		Object[]  a = {"A", "B", c, "E",d, "I"};
		System.out.println(doSomething(a));
	}
}
