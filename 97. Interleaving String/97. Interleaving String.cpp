class Solution {
	/*
	设状态f[i][j]，表示s1[0,i]和s2[0,j]，匹配s3[0, i+j]。如果s1的最后一个字符等于s3的最后一个字符，则f[i][j]=f[i-1][j]；
	如果s2的最后一个字符等于s3的最后一个字符，则f[i][j]=f[i][j-1]。因此状态转移方程如下：
	f[i][j] = (s1[i - 1] == s3 [i + j - 1] && f[i - 1][j]) || (s2[j - 1] == s3 [i + j - 1] && f[i][j - 1]);
	*/
public:
	bool isInterleave(string s1, string s2, string s3) {

		if (s1.size() + s2.size() != s3.size()) {
			return false;
		}

		vector<vector<bool>> f(s1.size() + 1, vector<bool>(s2.size() + 1, false));
		f[0][0] = true;

		for (int i = 1; i <= s1.size(); i++)
			f[i][0] = f[i - 1][0] && (s3[i - 1] == s1[i - 1]);

		for (int j = 1; j <= s2.size(); j++)
			f[0][j] = f[0][j - 1] && (s3[j - 1] == s2[j - 1]);

		for (int i = 1; i <= s1.size(); i++)
			for (int j = 1; j <= s2.size(); j++)
				f[i][j] = (f[i][j - 1] && s2[j - 1] == s3[i + j - 1]) || (f[i - 1][j] && s1[i - 1] == s3[i + j - 1]);

		return f[s1.size()][s2.size()];

	}
};