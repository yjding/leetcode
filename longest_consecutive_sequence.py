class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        if not num:
            return 0
        num_set = set(num)
        longest = 1 
        for i in num:
            left = i - 1 
            right = i + 1 
            count = 1 
            while left in num_set:
                num_set.remove(left)
                count += 1
                left -= 1
            while right in num_set:
                num_set.remove(right)
                count += 1
                right += 1
            longest = max(longest, count)
        return longest
