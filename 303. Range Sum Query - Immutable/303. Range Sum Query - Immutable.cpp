class NumArray {
public:
	NumArray(vector<int> nums) {
		if (nums.empty()) return;
		sum.push_back(nums[0]);
		for (int i = 1; i<nums.size(); i++) {
			sum.push_back(sum[i - 1] + nums[i]);
		}
	}

	int sumRange(int i, int j) {
		if (i == 0) return sum[j];
		if (j == 0) return 0;
		return sum[j] - sum[i - 1];
	}

private:
	vector<int> sum;
};

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(i,j);
*/