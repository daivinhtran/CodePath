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