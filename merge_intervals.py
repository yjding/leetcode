# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge_two_intervals(self, x, y):
        if y.start > x.end:
            return None
        elif y.end <= x.end:
            return Interval(x.start, x.end)
        else:
            return Interval(x.start, y.end)
            
    def merge(self, intervals):
        output = []
        intervals.sort(key=lambda x: x.start)
        if(len(intervals)<=1): return intervals
        x1, x2 = intervals[0], intervals[1]
        for y in intervals[2:]:
            x = self.merge_two_intervals(x1, x2)
            if x:
                x1 = x
                x2 = y
            else:
                output.append(x1)
                x1 = x2
                x2 = y
        x = self.merge_two_intervals(x1, x2)
        if x:
            output.append(x)
        else:
            output.append(x1)
            output.append(x2)
        return output
