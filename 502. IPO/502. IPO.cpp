class Solution {
public:
	int findMaximizedCapital(int k, int W, vector<int>& Profits, vector<int>& Capitals) {

		multimap<int, int> map;
		for (int i = 0; i < Capitals.size(); ++i) {
			map.insert(make_pair(Capitals[i], Profits[i]));
		}

		priority_queue<int> prique;
		while (k--) {
			for (auto iter = map.begin(); iter != map.end(); iter++) {//map的key自动按照升序排列
				if (iter->first <= W) {
					prique.push(iter->second);//优先队列里面存的是available的利润值
					map.erase(iter);
				}
				else break;
			}
			if (prique.empty()) break;
			W += prique.top();//优先队列top出来的是最大的数.
			prique.pop();//此轮在队列中留下的数在下一轮继续available
		}

		return W;
	}
};