class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        """
        类似3sum，用一个值维护与target最小差的和
        """
        nums.sort()
        minDiffSum=nums[0]+nums[1]+nums[2]
        for i in range(len(nums)-2):
            j=i+1
            k=len(nums)-1
            while j<k:
                if abs(nums[i]+nums[j]+nums[k]-target)<abs(minDiffSum-target):
                    minDiffSum=nums[i]+nums[j]+nums[k]
                if nums[i]+nums[j]+nums[k]>target:
                    k-=1
                else:
                    j+=1
        return minDiffSum