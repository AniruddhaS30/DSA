/*
Example 1:
Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
Example 2:
Input: num = 7
Output: false */
public class PerfectNumber {

    /**
     * Checks whether a given number is a Perfect Number.
     * A Perfect Number is equal to the sum of its proper divisors 
     * (all positive divisors excluding the number itself).
     *
     * Example: 28 = 1 + 2 + 4 + 7 + 14
     */
    public boolean checkPerfectNumber(int num) {

        // Perfect numbers are always greater than 1.
        // 1 is not considered a perfect number.
        if (num <= 1) {
            return false;
        }

        // Start the sum with 1, because 1 is always a proper divisor of any number > 1
        int sum = 1;

        // We only need to check up to the square root of num.
        // Reason: Divisors come in pairs (i and num/i).
        // Once i exceeds √num, we would just repeat the same pairs.
        for (int i = 2; i * i <= num; i++) {

            // Check if i is a divisor of num
            if (num % i == 0) {

                // Add the current divisor i to the sum
                sum += i;

                // Now add the corresponding pair divisor (num / i)
                // But only if it is different from i
                // (This prevents adding the same number twice when num is a perfect square)
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }

        // After collecting all proper divisors, check if their sum equals the original number
        return sum == num;
    }

    public static void main(String[] args) {
        int num = 28;

        // Create an object because checkPerfectNumber is not static
        PerfectNumber obj = new PerfectNumber();

        // Call the method using the object and print the result
        System.out.println(obj.checkPerfectNumber(num));
    }
}