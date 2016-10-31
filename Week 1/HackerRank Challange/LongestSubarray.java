    static int maxLength(int[] a, int k) {
        int sum = 0;
        int max = 0;
        int start= 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum+a[i];
            if (sum + a[i] > k) {
                max = Math.max(i - start, max);
                while (sum > k) 
                    sum = sum-a[start++];
            }
        }
        return Math.max(a.length - start,max);
    }

