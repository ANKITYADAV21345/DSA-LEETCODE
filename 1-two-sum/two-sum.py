#nikhil lohiya
class Solution:
    def twoSum(self, nums, target):
        # Create hashmap (dictionary in Python)
        num_map = {}

        for i in range(len(nums)):
            # Get the complement using the target value
            complement = target - nums[i]

            # Search the hashmap for complement, if found, we got our pair
            if complement in num_map:
                return [num_map[complement], i]

            # Put the element in hashmap for subsequent searches
            num_map[nums[i]] = i

        return [0, 0]

        