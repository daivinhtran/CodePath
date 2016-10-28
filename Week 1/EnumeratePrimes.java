/*
Challenge 2 - Enumerate all primes <= n
A prime number (or a prime) is an integer greater than 1 that has no positive divisors other than 1 and itself.

Write a program which takes as input an int value n and returns an array of int containing all unique primes <= n.

Example: if the value of n is 8, the function should return: {2,3,5,7}

Hint: One well-known algorithm for doing this is over 2,000 years old, but it's not the most efficient.

Remember, you are not allowed to use any primality testing functions.
 */
public class EnumeratePrimes {
    public static int[] enumeratePrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (int j = i*2; j < n; j += i) {
                    notPrimes[j] = true;
                }
            }
        }
        int[] primes = new int[count];
        int index = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                primes[index++] = i;
            }
        }
        return primes;
    }
    public static void main(String[] args) {
        int[] primes = enumeratePrimes(50);

        for (int i : primes) {
            System.out.println(i);
        }
    }
}
