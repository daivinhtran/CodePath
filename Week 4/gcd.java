public class gcd {
	public static int gcd(int a,int b) {
		return (a % b == 0 || b % a == 0) ? Math.min(a,b):gcd(Math.abs(a-b), Math.min(a,b));
	}
	public static int gcd(int[] x, int index) {
		if (index==1)
			return gcd(x[1],x[0]);
		return gcd(gcd(x, index-1),x[index]);
	}
	public static int gcd(int[] x) {
		return gcd(x, x.length-1);
	}
	public static void main(String[] args) {
		int[] a = {35, 35, 49, 42};
		System.out.println(gcd(a));
	}
}