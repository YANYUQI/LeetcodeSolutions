/**
* Definition for a binary tree node.
* struct TreeNode {
*     int val;
*     TreeNode *left;
*     TreeNode *right;
*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
class Solution {
public:
	int findBottomLeftValue(TreeNode* root) {
		int res;
		if (!root) return NULL;

		queue<TreeNode*> q;
		q.push(root);

		while (!q.empty()) {
			const int curLen = q.size();//局部const变量，在下一轮就会被更新
			for (int i = 0; i < curLen; ++i) {
				TreeNode* cur = q.front();
				if (i == 0) res = cur->val;
				if (cur->left) q.push(cur->left);
				if (cur->right) q.push(cur->right);
				q.pop();//std::queue 只负责管理和使用，不负责成员内存释放，所以可以pop之后还使用front的那个指针。不过为了不混和易于理解淆，此处最后再pop。
			}
		}

		return res;
	}
};