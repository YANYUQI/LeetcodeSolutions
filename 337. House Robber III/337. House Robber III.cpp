/**
* Definition for a binary tree node.
* struct TreeNode {
*     int val;
*     TreeNode *left;
*     TreeNode *right;
*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
/*拿root（第0层）为例，如果取第0层的节点，则第1层的节点不能取
；如果不取第0层的节点，则第1层的节点可取可不取。
这样我们需要记录下每个节点取与不取时能够获取的最大钱数
，通过深度优先遍历二叉树，最后取root节点返回的两个数值中大的就可以了。*/
class Solution {
	typedef pair<int, int> nodeMax;//nodeMax.first不包含此node的max，second包含此node的max
public:
	int rob(TreeNode* root) {
		nodeMax res = getMoney(root);
		return max(res.first, res.second);
	}
private:
	nodeMax getMoney(TreeNode* root) {
		nodeMax cur = make_pair(0, 0);
		if (!root) return cur;

		nodeMax l = getMoney(root->left);
		nodeMax r = getMoney(root->right);

		cur.first = max(l.first, l.second) + max(r.first, r.second);//不包含此点，那么在左右子树中取各自的最大值
		cur.second = root->val + l.first + r.first;//包含此点，那么下一层不能取，只能取各自子树不包含的最大值

		return cur;
	}
};