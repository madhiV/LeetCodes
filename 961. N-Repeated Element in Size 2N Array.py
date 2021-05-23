class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        n=len(nums)
        for i in range(n-1):
            for j in range(i+1,n):
                if(nums[i]==nums[j]):
                    return nums[i]
