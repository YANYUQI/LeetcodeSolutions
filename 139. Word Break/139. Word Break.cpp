class Solution {
public:
	bool wordBreak(string s, vector<string>& wordDict) {
		vector<bool> f(s.size() + 1, false);
		f[0] = true;
		for (int i = 0; i < s.size() + 1; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (f[j] == true && find(wordDict.begin(), wordDict.end(), s.substr(j, i - j)) != wordDict.end()) {
					f[i] = true;
					break;
				}
			}
		}
		return f[s.size()];
	}
};

//notes:
//str.substr(startpos, length)
//vector的find：find(vector.begin(),vector.end(),value) != vector.end() vector要引用指针
//setdefind: set.find(value) != set.end() set直接调用方法