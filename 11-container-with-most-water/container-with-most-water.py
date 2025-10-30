class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        m=[]
        i=0
        j=len(height)-1
        while(i<=j):
            if(height[i]<=height[j]):
                h=height[i]
            else:
                h=height[j]
            w=j-i
            m.append(h*w)
            if(height[i]<=height[j]):
                i+=1
            else:
                j-=1
        return max(m)
        
        