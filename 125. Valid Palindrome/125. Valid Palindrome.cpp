class Solution {
public:
	bool isPalindrome(string s) {
		transform(s.begin(), s.end(), s.begin(), ::tolower);//tolower在这里为什么要加::？remians
		auto left = s.begin(), right = prev(s.end());//不用指针，用string.at()也可以，和java的charAt类似
		while (left < right) {
			if (!isalnum(*left)) advance(left, 1);//或者++left;
												  //如果是一个数字或字母，isalnum这个函数返回非零值；否则为0
			else if (!isalnum(*right)) advance(right, -1);//或者++right;   或者right=prev(right,1)；
														  //advance(left,1)  vs  right=prev(right,1) ————注意：prev不修改指针原值，只会返回一个新的指针。而advance直接修改原值。
			else if (*left != *right) return false;
			else { left++, right--; }
		}
		return true;
	}
};