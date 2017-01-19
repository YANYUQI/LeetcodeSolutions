class Solution {
public:
	int maxProduct(vector<int>& nums) {
		int curMin = nums[0];
		int curMax = nums[0];
		int maxPro = nums[0];

		for (int i = 1; i < nums.size(); i++) {
			int tmpCurMax = max(max(nums[i] * curMax, nums[i] * curMin), nums[i]);
			curMin = min(min(nums[i] * curMax, nums[i] * curMin), nums[i]);
			curMax = tmpCurMax;
			maxPro = max(curMax, maxPro);
		}

		return maxPro;
	}
};