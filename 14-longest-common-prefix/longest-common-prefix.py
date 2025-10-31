class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        a=list(strs[0])
        for i in range(1,len(strs)):
            ans=[]
            d=[]
            b=list(strs[i])

            if len(b)>=len(a):
                d=a
            else:
                d=b
            for c in range(0,len(d)):
                if b[c]==a[c]:
                    ans.append(a[c])
                else:
                    break
            a=[]
            a=ans
        return "".join(a)

        
        