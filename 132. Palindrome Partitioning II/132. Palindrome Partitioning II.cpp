class Solution {
public:
	int minCut(string s) {
		const int n = s.size();
		int f[n + 1];//f(i)=区间[i, n-1]之间最小的cut数
		bool p[n][n];//判断[i,j]是否是回文
		fill_n(&p[0][0], n * n, false);
		//fill_n函数的作用是：参数包括 : 一个迭代器，一个计数器以及一个值。该函数从迭代器指向的元素开始，将指定数量的元素设置为给定的值。

		//the worst case is cutting by each char.
		//the worst case的初始化
		for (int i = 0; i <= n; i++) {
			f[i] = n - 1 - i; // 最后一个f[n]=-1
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s[i] == s[j] && (j - i < 2 || p[i + 1][j - 1])) {//那么P[i][j]也为回文
					p[i][j] = true;
					f[i] = min(f[i], f[j + 1] + 1);
				}
			}
		}
		return f[0];
	}
};