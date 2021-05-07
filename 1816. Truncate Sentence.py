#!/usr/bin/env python
# coding: utf-8

# In[ ]:


class Solution:
    def truncateSentence(self, s: str, k: int) -> str:
        t=0
        for i in range(len(s)):
            if s[i]==" ":
                t+=1
            if i==len(s)-1:
                return s
            if t==k:
                return s[0:i]

