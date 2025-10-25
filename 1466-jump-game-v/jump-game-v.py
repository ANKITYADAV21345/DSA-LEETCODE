class Solution(object):
    def maxJumps(self, arr, d):
        """
        :type arr: List[int]
        :type d: int
        :rtype: int
        """
        n = len(arr)
        dp = [0] * n  # memoization (0 means uncomputed)

        def dfs(i):
            if dp[i] != 0:
                return dp[i]

            res = 1  # Minimum (stay in place)

            # Move left
            for j in range(i - 1, i - d - 1, -1):
                if j < 0 or arr[j] >= arr[i]:
                    break
                res = max(res, 1 + dfs(j))

            # Move right
            for j in range(i + 1, i + d + 1):
                if j >= n or arr[j] >= arr[i]:
                    break
                res = max(res, 1 + dfs(j))

            dp[i] = res
            return res

        ans = 0
        for i in range(n):
            ans = max(ans, dfs(i))

        return ans


    