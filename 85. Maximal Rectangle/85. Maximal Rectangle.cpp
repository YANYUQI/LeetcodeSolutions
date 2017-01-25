class Solution {
	//两种方法：http://blog.csdn.net/makuiyu/article/details/44857479
public:
	int maximalRectangle(vector<vector<char>>& matrix) {
		if (matrix.size() == 0 || matrix[0].size() == 0)
			return 0;

		int res = 0;
		vector<int> height(matrix[0].size(), 0);
		for (int i = 0; i < matrix.size(); ++i)
		{
			for (int j = 0; j < matrix[0].size(); ++j)
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
			res = max(res, largestRectangleArea(height));
		}
		return res;
	}

private:
	int largestRectangleArea(vector<int> &height) {
		int res = 0;
		stack<int> si;
		height.push_back(0);
		for (int i = 0; i < height.size(); ++i)
		{
			while (!si.empty() && height[si.top()] >= height[i])
			{
				int h = height[si.top()];
				si.pop();
				int s = h * (si.empty() ? i : (i - si.top() - 1));
				res = max(res, s);
			}
			si.push(i);
		}
		return res;
	}
};