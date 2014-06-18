# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
    
    def __repr__(self):
        return "(%d, %d)" % (self.start, self.end)

class Solution:
    # @param intervals, a list of Intervals
    # @param newInterval, a Interval
    # @return a list of Interval
    def merge_two_intervals(self, x, y):
        if y.start > x.end:
            return None
        elif y.end <= x.end:
            return Interval(x.start, x.end)
        else:
            return Interval(x.start, y.end)
            
    def insert(self, intervals, newInterval):
        output = []
        i, x, y = 0, newInterval, None
        while(i<len(intervals)):
            if intervals[i].end < newInterval.start:
                output.append(intervals[i])
            else:
                x = self.merge_two_intervals(intervals[i], x) if intervals[i].start < x.start else self.merge_two_intervals(x, intervals[i])
                if x:
                    y = x
                else:
                    break
            i += 1
        if y:
            output.append(y)
        else:
            output.append(newInterval)
        while(i<len(intervals)):
            output.append(intervals[i])
            i += 1
        return output

if __name__ == '__main__':
    solution = Solution()
    print solution.insert([Interval(2,4),Interval(5,7),Interval(8,10),Interval(11,13)], Interval(3,8))

