class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 用set保存所有数。然后遍历每个数，往前往后双方向搜索连续的个数（每次搜索到一个，就从set中remove掉，这样才保证是O(n)的复杂度）
        a = set(nums)
        countMax = 0
        for x in nums:
            if x not in a: continue

            count = 1
            tmp = x - 1
            while tmp in a:
                count += 1
                a.remove(tmp)
                tmp -= 1
            tmp = x + 1
            while tmp in a:
                count += 1
                a.remove(tmp)
                tmp += 1

            countMax = max(countMax, count)

        return countMax