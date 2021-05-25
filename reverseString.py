class Solution:
    def reverseString(self, s: List[str]) -> None:
        n=len(s)
        for i in range(n//2):
            j=n-i-1
            temp=s[i]
            s[i]=s[j]
            s[j]=temp
        return s
