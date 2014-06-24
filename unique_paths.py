class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        board = []
        for i in range(m):
            row = list()
            for i in range(n):
                row.append(0)
            board.append(row)
        for i in range(m):
            board[i][n-1] = 1
        for j in range(n):
            board[m-1][j] = 1
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                board[i][j] = board[i+1][j] + board[i][j+1]
        return board[0][0] 

if __name__ == '__main__':
    solution = Solution()
    print solution.uniquePaths(23, 12)

