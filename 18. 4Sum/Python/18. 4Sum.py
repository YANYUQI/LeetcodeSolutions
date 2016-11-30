class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        '''
        The idea is from http://www.cnblogs.com/zuoyuan/p/3699384.html
        需要用到哈希表的思路，这样可以空间换时间，以增加空间复杂度的代价来降低时间复杂度。
        首先建立一个字典dict，字典的key值为数组中每两个元素的和，每个key对应的value为这两个元素的下标组成的元组，元组不一定是唯一的。
        如对于num=[1,2,3,2]来说，dict={3:[(0,1),(0,3)], 4:[(0,2),(1,3)], 5:[(1,2),(2,3)]}。
        这样就可以检查target-key这个值在不在dict的key值中，如果target-key在dict中并且下标符合要求，
        那么就找到了这样的一组解。由于需要去重，这里选用set() 类型的数据结构,
        即无序无重复元素集。 最后将每个找出来的解(set()类型)转换成list类型输出即可。
        '''
        dict = {}
        res = set()
        nums.sort()
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                sum = nums[i] + nums[j]
                if sum in dict:
                    dict[sum].append((i, j))
                else:
                    dict[sum] = [(i, j)]

        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                diff = target - nums[i] - nums[j]
                if diff in dict:
                    for k in dict[diff]:
                        if k[0] > j:
                            res.add((nums[i], nums[j], nums[k[0]], nums[k[1]]))

        return list(res)