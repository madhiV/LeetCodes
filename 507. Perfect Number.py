import math
class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        sum_=0
        if num==1:
            return False
        for i in range(2,int(math.sqrt(num))+1):
            if num%i==0:
                sum_+=(i+num//i)
        return sum_+1==num
