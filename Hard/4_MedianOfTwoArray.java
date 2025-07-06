class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];

        int p1 = 0, p2 = 0, p3 = 0;

        // Merge the two sorted arrays into ans[]
        while (p1 < arr1.length || p2 < arr2.length) {
            int val1 = (p1 < arr1.length) ? arr1[p1] : Integer.MAX_VALUE;
            int val2 = (p2 < arr2.length) ? arr2[p2] : Integer.MAX_VALUE;

            if (val1 < val2) {
                ans[p3++] = val1;
                p1++;
            } else {
                ans[p3++] = val2;
                p2++;
            }
        }

        // Calculate median
        int n = ans.length;
        if (n % 2 == 1) {
            return ans[n / 2];
        } else {
            return (ans[n / 2 - 1] + ans[n / 2]) / 2.0;
        }
    }
}
