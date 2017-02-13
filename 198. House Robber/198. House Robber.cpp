class Solution {
public:
	int rob(vector<int>& nums) {

		if (nums.empty()) return 0;
		if (nums.size() == 1) return nums[0];
		if (nums.size() == 2) return max(nums[0], nums[1]);

		vector<int> cash(nums.size(), 0);
		cash[0] = nums[0];
		cash[1] = max(nums[0], nums[1]);
		for (int i = 2; i<nums.size(); i++) {
			cash[i] = max(cash[i - 1], cash[i - 2] + nums[i]);
		}
		return cash[nums.size() - 1];
	}
};