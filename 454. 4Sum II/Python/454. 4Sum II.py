class Solution(object):
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        '''
        先保存a+b的所有取值，然后遍历所有c+d的组合，分成两部分算起来更快
        '''
        dict = {}
        count = 0

        for i in A:
            for j in B:
                dict[i + j] = dict.get(i + j, 0) + 1

        for i in C:
            for j in D:
                count += dict.get(-i - j, 0)

        return count