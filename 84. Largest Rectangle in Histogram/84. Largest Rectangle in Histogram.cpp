class Solution {
	//reference£ºhttp://blog.csdn.net/doc_sgl/article/details/11805519
public:
	int largestRectangleArea(vector<int> &height) {
		height.push_back(0);
		stack<int> stk;
		int i = 0;
		int maxArea = 0;
		while (i < height.size()) {
			if (stk.empty() || height[stk.top()] <= height[i]) {
				stk.push(i++);
			}
			else {
				int t = stk.top();
				stk.pop();
				maxArea = max(maxArea, height[t] * (stk.empty() ? i : i - stk.top() - 1));
			}
		}
		return maxArea;
	}
};