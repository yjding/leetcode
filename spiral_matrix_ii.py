class Solution:
    # @return a list of lists of integer
    def generateMatrix(self, n):
        output = []
        for i in range(n):
            row = list()
            for i in range(n):
                row.append(0)
            output.append(row)
        value = 1
        xstart, xend, ystart, yend = 0, n-1, 0, n-1
        while True:
            for i in range(xstart, xend+1):
                output[ystart][i] = value
                value += 1
            ystart += 1
            if ystart > yend: break
            for i in range(ystart, yend+1):
                output[i][xend] = value
                value += 1
            xend -= 1
            if xend < xstart: break
            for i in range(xend, xstart-1, -1):
                output[yend][i] = value
                value += 1
            yend -=1
            if yend < ystart: break
            for i in range(yend, ystart-1, -1):
                output[i][xstart] = value
                value += 1
            xstart += 1
            if xstart > xend: break
        return output
