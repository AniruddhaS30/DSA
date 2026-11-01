/*  LEETCODE - 739 - IMPORTANT
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0] */
import java.util.ArrayDeque;   // Import ArrayDeque – a fast implementation of a double-ended queue
import java.util.Deque;        // Import Deque interface – we will use it as a stack
import java.util.*;            // Import everything else we need (mainly Arrays for printing)

class DailyTemperatures {      // Class that contains the solution

    // Main function that solves the problem
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;          // Store the length of the input array for easy use
        int[] result = new int[n];            // Create the answer array (all values start as 0)

        // Create an empty stack that will store indices of days still waiting for a warmer temperature
        Deque<Integer> stack = new ArrayDeque<>();

        // Loop through every day from left to right
        for (int i = 0; i < n; i++) {

            // While the stack is not empty AND today's temperature is warmer than
            // the temperature of the day that is currently on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();          // Remove the older day from the stack
                result[prevIndex] = i - prevIndex;    // Calculate how many days we waited and store it
            }

            // After resolving all possible older days, push today's index onto the stack
            // (this day is now waiting for a future warmer day)
            stack.push(i);
        }

        // Any days still left in the stack never found a warmer day, so they stay 0
        return result;   // Return the completed answer array
    }

    // Simple test method so we can run the program and see the output
    public static void main(String[] args) {
        DailyTemperatures Daily = new DailyTemperatures();          // Create an object of the class
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};      // Example input
        int[] answer = Daily.dailyTemperatures(temperatures);       // Call the function
        System.out.println(Arrays.toString(answer));                // Print the result nicely
    }
}