class Solution {
public:
	int longestPalindromeSubseq(string s) {
		const int len = s.size();
		int dp[len][len];

		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;//µ¥¸ö×Ö·ûÊÇpalin
		}

		for (int j = 1; j < len; ++j) {
			for (int i = j - 1; i >= 0; --i) {
				if (s[i] == s[j]) {
					dp[i][j] = i + 1 <= j - 1 ? dp[i + 1][j - 1] + 2 : 2;
				}
				else {
					dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}
};