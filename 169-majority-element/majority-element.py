# apna college article
class Solution:
    def majorityElement(self, nums):
        n = len(nums)
        count = 1
        majority = nums[0]

        # phase 1 find candidate
        for i in range(1, n):
            if nums[i] == majority:
                count = count + 1
            else:
                count = count - 1
                if count == 0:
                    majority = nums[i]
                    count = 1

        # phase 2 verify candidate
        if nums.count(majority) > n // 2:
            return majority
        else:
            return -1


if __name__ == "__main__":
    nums = [2,2,1,1,2,2,2]

    Sol = Solution()
    result = Sol.majorityElement(nums)

    if result != -1:
        print(result)
    else:
        print(-1)

        
        