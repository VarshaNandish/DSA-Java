public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;          // Pointer for nums1
        int p2 = n - 1;          // Pointer for nums2
        int p = m + n - 1;       // Pointer for placement in nums1

        // Merge from back to front
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining nums2 elements if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

        // Print result
        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
