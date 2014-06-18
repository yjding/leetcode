class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        count = 0
        end = len(s) - 1
        while end>=0 and s[end]==' ': end-=1
        if end < 0: return 0
        for c in s[:end+1]:
            if c!=' ': count+=1
            else: count=0
        return count
