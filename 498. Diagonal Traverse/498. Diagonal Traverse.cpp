class Solution {
	/*由大化小----》先划分为求所有斜行的数字集合，最后再去一个顺序一个倒序穿插到一起：
	先假设所有的方向都是斜向上的，也就是从matrix[0][0]开始，matrix[1][0]、matrix[2, 0]...matrix[m-1][0]也就是第一列的所有数为开头，
	然后还有最后一行的所有数为开头，寻找matrix[i-1][j+1]是否存在，存在就将它放入temp数组中，temp的每一行表示斜着的一行元素的序列。
	这样当temp数组的行数是奇数的时候，就从后往前一次放入到result数组中，如果是偶数就从前往后依次放入result数组中，返回result数组即为所求～*/
public:
	vector<int> findDiagonalOrder(vector<vector<int>>& matrix) {
		vector<int> result;
		int m = matrix.size();
		if (m == 0) return result;
		int n = matrix[0].size(), index = 0;
		vector<vector<int>> temp(m + n - 1);
		for (int i = 0; i < m; i++, index++) {
			temp[index].push_back(matrix[i][0]);
			for (int x = i, y = 0; x - 1 >= 0 && y + 1 < n; x--, y++)
				temp[index].push_back(matrix[x - 1][y + 1]);
		}
		for (int j = 1; j < n; j++, index++) {
			temp[index].push_back(matrix[m - 1][j]);
			for (int x = m - 1, y = j; x - 1 >= 0 && y + 1 < n; x--, y++)
				temp[index].push_back(matrix[x - 1][y + 1]);
		}
		for (int i = 0; i < m + n - 1; i++) {
			if (i % 2 == 1) {
				for (int j = temp[i].size() - 1; j >= 0; j--)
					result.push_back(temp[i][j]);
			}
			else {
				for (int j = 0; j < temp[i].size(); j++)
					result.push_back(temp[i][j]);
			}
		}
		return result;
	}
};