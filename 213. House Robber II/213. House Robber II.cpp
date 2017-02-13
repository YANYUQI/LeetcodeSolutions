class Solution {
public:
	int rob(vector<int>& nums) {
		int n = nums.size();
		if (n == 0) return 0;
		if (n == 1) return nums[0];

		int* dp = new int[n + 1];
		//抢第一家：抢第一家到倒数第二家得到的金钱最大值
		dp[0] = nums[0];
		for (int i = 1; i < n - 1; ++i) {
			dp[i] = max(dp[i - 1], (i == 1 ? 0 : dp[i - 2]) + nums[i]);
		}
		int res1 = dp[n - 2];

		//不抢第一家：抢第二家到最后一家得到的金钱最大值
		dp[1] = nums[1];
		for (int i = 2; i < n; ++i) {
			dp[i] = max(dp[i - 1], (i == 2 ? 0 : dp[i - 2]) + nums[i]);
		}
		int res2 = dp[n - 1];

		return max(res1, res2);//返回二者的较大值
	}
};