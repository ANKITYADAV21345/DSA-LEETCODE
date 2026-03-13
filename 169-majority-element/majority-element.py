# map aproach apna college article
# importing typing module for type hints(optional but good practice)
from typing import List
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n=len(nums)
        # dictonary to store frequencies
        freq={}

        # traverse the list and count frequencies
        for num in nums:
            # update frequency
            freq[num]=freq.get(num,0)+1

            if freq[num]>n//2:
                return num
        return -1

        # run the test directly
        if __name__=="__main__":
            nums=[2,2,1,1,2,2,2]

            # create an object of Solution class
            Sol=Solution()

            #call the majorityElement methord
            result=Sol.majorityElement(nums)

            # print the result
            if result!=-1:
                print(result)
            else:
                print(-1)

        