class Solution(object):
    def canReach(self, arr, start):
        """
        :type arr: List[int]
        :type start: int
        :rtype: bool
        """

        q = deque([start])
        
        while q:
            curr = q.popleft()
            
            if arr[curr] == 0:
                return True
            
            if arr[curr] < 0:
                continue
            
            if curr + arr[curr] < len(arr):
                q.append(curr + arr[curr])
            
            if curr - arr[curr] >= 0:
                q.append(curr - arr[curr])
            
            arr[curr] = -arr[curr]  # mark as visited
        
        return False


arr = [3, 0, 2, 1, 2]
start = 2
print(Solution().canReach(arr, start))  # Output: True

        