class Solution {
public:
	vector<string> wordBreak(string s, vector<string>& wordDict) {
		vector<bool> f(s.size() + 1, false);
		vector<vector<bool>> word(s.size() + 1, vector<bool>(s.size() + 1, false));
		f[0] = true;
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if (f[j] && find(wordDict.begin(), wordDict.end(), s.substr(j, i - j)) != wordDict.end()) {
					f[i] = true;
					word[j][i] = true;//[j,i)是一个word
				}
			}
		}
		vector<string> path;
		vector<string> res;
		dfs(s, word, s.size(), path, res);
		return res;
	}

private:
	void dfs(const string &s, const vector<vector<bool>> &word, int cur, vector<string> &path, vector<string> &res) {
		if (cur == 0) {
			string pathStr;
			for (auto reverseIter = path.crbegin(); reverseIter != path.crend(); reverseIter++) {//注意反转迭代器，也是用++来迭代，不是--
				pathStr += *reverseIter + " ";
			}
			pathStr.erase(pathStr.end() - 1);//minus the blank
			res.push_back(pathStr);
		}

		for (int i = 0; i<cur; i++) {
			if (word[i][cur]) {
				path.push_back(s.substr(i, cur - i));
				dfs(s, word, i, path, res);
				path.pop_back();
			}
		}
	}
};