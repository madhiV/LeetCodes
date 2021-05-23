class Solution:
    def sumBase(self, n: int, k: int) -> int:
        sum_=0
        while n!=0:
            sum_+=n%k
            n//=k
        return sum_
