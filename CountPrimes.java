/*
Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:
Input: n = 0
Output: 0
Example 3:
Input: n = 1
Output: 0 */
public class CountPrime {

    /**
     * Counts how many prime numbers are strictly less than n
     * using the Sieve of Eratosthenes algorithm.
     */
    public int countPrime(int n) {

        // If n is 2 or less, there are no primes less than n
        if (n <= 2) {
            return 0;
        }

        // Create a boolean array of size n
        // isPrime[i] will be true if 'i' is a prime number
        boolean[] isPrime = new boolean[n];

        // Initialize the array:
        // We assume all numbers from 2 to n-1 are prime at the beginning
        // (0 and 1 are left as false because they are not prime)
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes process
        // We only need to check up to square root of n
        for (int i = 2; i * i < n; i++) {

            // If i is still marked as prime
            if (isPrime[i]) {

                // Mark all multiples of i as not prime
                // Start from i*i because smaller multiples are already marked
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count how many numbers are still marked as prime
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        // Return the total number of primes less than n
        return count;
    }

    public static void main(String[] args) {
        int n = 30;

        // Create an object of the class
        CountPrime obj = new CountPrime();

        // Call the method and print the result
        System.out.println(obj.countPrime(n));
    }
}