class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        n,m=len(mat),len(mat[0])
        if r*c!=n*m:
            return mat
        x,y=0,0
        res=[]
        for i in range(r):
            k=[]
            for j in range(c):
                k.append(mat[x][y])
                y+=1
                if y==m:
                    y=0
                    x+=1
            res.append(k)
        return res
