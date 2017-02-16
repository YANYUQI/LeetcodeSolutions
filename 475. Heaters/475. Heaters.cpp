class Solution {
public:
	int findRadius(vector<int>& houses, vector<int>& heaters) {
		sort(heaters.begin(), heaters.end(), less<int>());//greater<int>()是从大到小，less是从小到大，不小心记混了
		int res = 0;
		for (int i = 0; i<houses.size(); ++i) {
			if (!binary_search(heaters.begin(), heaters.end(), houses[i])) {//binary_search返回值bool
				auto index = upper_bound(heaters.begin(), heaters.end(), houses[i]) - heaters.begin();//upperbound返回第一个大于的，lowerbound返回第一个等于或者大于的
				int right = (index<heaters.size() ? heaters[index] - houses[i] : INT_MAX);
				int left = (index - 1 >= 0 ? houses[i] - heaters[index - 1] : INT_MAX);
				res = max(res, min(right, left));
			}
		}
		return res;
	}
};