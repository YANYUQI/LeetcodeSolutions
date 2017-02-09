//REFERENCE:http://blog.csdn.net/worldwindjp/article/details/19770281
class Solution {
public:
	int numDistinct(const string &S, const string &T) {
		vector<int> f(T.size() + 1);
		f[0] = 1;
		for (int i = 0; i < S.size(); ++i) {
			for (int j = T.size() - 1; j >= 0; --j) {
				f[j + 1] += S[i] == T[j] ? f[j] : 0;//用到了滚动数组
			}
		}

		return f[T.size()];
	}
};