class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        t=arr[len(arr)-1]
        for i in range(len(arr)-2,-1,-1):
            b=t
            if arr[i]>t:
                t=arr[i]
            arr[i]=b
        arr[len(arr)-1]=-1
        return arr
