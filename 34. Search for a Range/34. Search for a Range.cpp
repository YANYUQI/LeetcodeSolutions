class Solution {
	// 类似二分查找，但等于目标值时需要向左向右对其相邻元素进行判断。
public:
	vector<int> searchRange(vector<int>& nums, int target) {
		int left = 0;
		int right = nums.size() - 1;

		vector<int> result;
		result.push_back(-1);
		result.push_back(-1);

		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (nums[mid] > target)
			{
				right = mid - 1;
			}
			else if (nums[mid] < target)
			{
				left = mid + 1;
			}
			else
			{
				result[0] = mid;
				result[1] = mid;

				int j = mid - 1;
				while (j >= 0 && nums[j] == target)
				{
					result[0] = j;
					j--;
				}

				j = mid + 1;
				while (j < nums.size() && nums[j] == target)
				{
					result[1] = j;
					j++;
				}

				break;
			}
		}

		return result;
	}
};