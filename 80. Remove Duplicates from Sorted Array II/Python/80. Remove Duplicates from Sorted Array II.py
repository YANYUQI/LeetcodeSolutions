class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        '''
        思路两种：
        1，从前面开始遍历，用count计重复个数，大于2就不要直接continue，小于等于二就留下到对应位数。
        2，从末尾开始遍历（第一个和第二个数不用遍历），只要当前值不等于前两个那个值就说明可以count进去，先存到list的末尾。然后再一次存到前面来。
        '''
        count = 0
        l = len(nums)
        if l <= 2: return l
        for i in range(l - 1, 1, -1):
            if nums[i] != nums[i - 2]:
                nums[l - 1 - count] = nums[i]
                count += 1
        length = count + 2
        for j in range(2, 2 + count):
            nums[j] = nums[-count]
            count -= 1
        return length

