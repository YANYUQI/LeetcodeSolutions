class Solution {
public:
	int maxSubArray(vector<int>& nums) {
		int curSum = nums[0];
		int maxSum = nums[0];

		for (int i = 1; i<nums.size(); i++) {
			if (curSum > 0) {
				curSum += nums[i];
			}
			else {
				curSum = nums[i];
			}
			maxSum = max(maxSum, curSum);
		}

		return maxSum;
	}
};