class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for (int i = 0; i<n; i++){
            minH.add(nums[i]);
                if (minH.size() > k) {
                    minH.remove();
                }
            }
        return minH.peek();
    }
}
