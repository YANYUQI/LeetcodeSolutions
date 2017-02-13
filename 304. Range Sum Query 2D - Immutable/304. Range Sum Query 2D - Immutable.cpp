class NumMatrix {
public:
	NumMatrix(vector<vector<int>> matrix) {
		if (matrix.empty()) return;
		sums = vector<vector<int>>(matrix.size(), vector<int>(matrix[0].size(), 0));
		for (int i = 0; i<matrix.size(); i++) {
			if (matrix[i].empty()) return;
			sums[i][0] = matrix[i][0];
			for (int j = 1; j<matrix[i].size(); j++) {
				sums[i][j] = sums[i][j - 1] + matrix[i][j];
			}
		}
	}

	int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += (sums[i][col2] - (col1 == 0 ? 0 : sums[i][col1 - 1]));
		}
		return sum;
	}

private:
	vector<vector<int>> sums;
};

/**
* Your NumMatrix object will be instantiated and called as such:
* NumMatrix obj = new NumMatrix(matrix);
* int param_1 = obj.sumRegion(row1,col1,row2,col2);
*/