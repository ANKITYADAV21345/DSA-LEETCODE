from collections import deque, defaultdict

class Solution(object):
    def minJumps(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        if n == 1:
            return 0

        # Build value -> list of indices map
        cache = defaultdict(list)
        for i, val in enumerate(arr):
            cache[val].append(i)

        visited = set([0])
        queue = deque([0])
        steps = 0

        # BFS traversal
        while queue:
            for _ in range(len(queue)):
                i = queue.popleft()
                if i == n - 1:
                    return steps

                # all indices we can jump to
                indices = cache[arr[i]] + [i - 1, i + 1]

                for k in indices:
                    if 0 <= k < n and k not in visited:
                        visited.add(k)
                        queue.append(k)

                # reset instead of .clear() for Python 2 support
                cache[arr[i]] = []

            steps += 1

        return -1
