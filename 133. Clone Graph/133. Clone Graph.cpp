/**
* Definition for undirected graph.
* struct UndirectedGraphNode {
*     int label;
*     vector<UndirectedGraphNode *> neighbors;
*     UndirectedGraphNode(int x) : label(x) {};
* };
*/

//用queue实现广度优先搜索
class Solution {
public:
	UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
		if (node == nullptr) return nullptr;//std::nullptr_t 是c++空指针类型的文字，nullptr.在c++11中引入的

		unordered_map<int, UndirectedGraphNode *> copied;

		queue<const UndirectedGraphNode *> q;
		q.push(node);
		copied[node->label] = new UndirectedGraphNode(node->label);//new一个的返回值是指针

		while (!q.empty()) {
			const UndirectedGraphNode *cur = q.front();//fornt取队列的第一个
			q.pop();

			for (UndirectedGraphNode *nbr : cur->neighbors) {

				if (copied.find(nbr->label) == copied.end()) {  //not exist
					copied[nbr->label] = new UndirectedGraphNode(nbr->label);
					copied[cur->label]->neighbors.push_back(copied[nbr->label]);
					q.push(nbr);
				}
				else {                                       //exist
					copied[cur->label]->neighbors.push_back(copied[nbr->label]);
				}
			}
		}
		return copied[node->label];
	}
};