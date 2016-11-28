class Solution(object):
    '''
    思路有两种:
    第一种是将nums从小到大排序，两个指针一个头一个尾，如果和大于target就向左移动右指针，小于target则向右移动左指针，直到等于target。
    第二种是从第一个开始轮询记为x，检查target-x值是否存在于target中（可用dict，从而可以顺便保存索引值），存在就说明相加等于target。
    此代码选用第二种，代码更加简洁快速。
    '''
    def twoSum(self, nums, target):

        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict={ }
        for i in range(len(nums)):
            x=nums[i]
            if target-x in dict:
                return (dict[target-x],i)
            dict[x]=i