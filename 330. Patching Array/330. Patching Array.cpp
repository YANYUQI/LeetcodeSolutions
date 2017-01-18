class Solution {
	/*假设数组当前可以表示的范围为[1, total)内的所有数字，
	那么向数组中添加元素add可以将表示范围扩充至[1, total + add)，
	其中add≤total。当且仅当add=total时取到范围上限[1, 2 * total)。
	当数组中有小于等于add的元素时，则利用数组中的元素。
	若没有，则添加新元素add。*/
public:
	int minPatches(vector<int>& nums, int n) {
		long total = 1;
		int count = 0;

		for (int i = 0; total <= n;) {
			if (i<nums.size() && nums[i] <= total) {
				total += nums[i++];
			}
			else {
				total <<= 1;
				count++;
			}
		}

		return count;
	}
};