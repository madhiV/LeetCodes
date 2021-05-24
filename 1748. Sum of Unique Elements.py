class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        d={}
        sum_=0
        for i in range(len(nums)):
            if d.get(nums[i])==None:
                d[nums[i]]=1
            else:
                d[nums[i]]+=1
        for x in d:
            if d.get(x)==1:
                sum_+=x
        return sum_
