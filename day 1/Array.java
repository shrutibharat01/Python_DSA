// Q1. Maximum sum subarray
// Kadane's algorithm
public class MaximumSumSubarrayOptimized {
    public static void main(String[] args) {
        int[] L = {-2, 4, 7, -1, 6, -11, 14, 3, -1, -6};
        
        int maxSum = L[0];  // Initialize maxSum with the first element
        int currentSum = L[0];  // Initialize currentSum with the first element
        int start = 0;
        int end = 0;
        int tempStart = 0;
        
        for (int i = 1; i < L.length; i++) {
            // Decide whether to add the current number to the existing subarray or start a new subarray
            if (L[i] > currentSum + L[i]) {
                currentSum = L[i];
                tempStart = i;
            } else {
                currentSum += L[i];
            }
            
            // Update maxSum and subarray indices if we found a new maximum sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        
        // Print the maximum sum and the corresponding subarray
        System.out.println("Maximum sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(L[i] + " ");
        }
    }
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------
// Q2. Find the element with left side smaller and right side greater in array.
public class ElementWithLeftSmallerRightGreaterOptimized {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 8, 7, 9};
        
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        
        // Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        
        // Fill rightMin array
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        
        // Find an index where leftMax is less than or equal to arr[i] and rightMin is greater than or equal to arr[i]
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= leftMax[i - 1] && arr[i] <= rightMin[i + 1]) {
                System.out.println("Element with left side smaller and right side greater: " + arr[i]);
                return;
            }
        }
        
        System.out.println("No such element found.");
    }
}
