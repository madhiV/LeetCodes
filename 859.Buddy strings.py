class Solution:
    def buddyStrings(self, a: str, b: str) -> bool:
        x=list(a)
        n=len(a)
        for i in range(n-1):
            for j in range(i+1,n):
                if x[i]==x[j]:
                    continue
                else:
                    temp=x[i]
                    x[i]=x[j]
                    x[j]=temp
                    if(''.join(x)==b):
                        return True
                    temp=x[i]
                    x[i]=x[j]
                    x[j]=temp
        return False
                    
