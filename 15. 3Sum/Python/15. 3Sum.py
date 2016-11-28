class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        '''
        先确定一个数不动，剩下的数按照2sum的方法搜寻，此处可以先排序后夹逼，复杂度O(n^2)
        注意去重。且注意，如只有k-=1，则不需要对j进行去重，反之亦然，所以j和k的去重不可以放在while循环之外,think abou it.
        '''
        nums.sort()
        list=[]
        i=0
        while i <len(nums)-2:
            j=i+1
            k=len(nums)-1
            while j<k:
                if nums[j]+nums[k]==-nums[i]:
                    list.append([nums[i],nums[j],nums[k]])
                    j+=1
                    k-=1
                    while j<k and nums[j]==nums[j-1]: #j去重
                        j+=1
                    while j<k and nums[k]==nums[k+1]: #k去重
                        k-=1
                elif nums[j]+nums[k]>-nums[i]:
                    k-=1
                    while j<k and nums[k]==nums[k+1]: #k去重,这个和下面一个的去重可以不要，但是加上runtime变小
                        k-=1
                else:
                    j+=1
                    while j<k and nums[j]==nums[j-1]: #j去重
                        j+=1
            i+=1
            while i <len(nums)-2 and nums[i]==nums[i-1]: #i去重
                i+=1
        return list