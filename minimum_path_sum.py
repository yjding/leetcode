class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        m = len(grid)
        if not m: return 0
        n = len(grid[0])
        if not n: return 0
        board = []
        for i in range(m):
            row = list()
            for j in range(n):
                row.append(0)
            board.append(row)
        board[m-1][n-1] = grid[m-1][n-1]
        for i in range(m-2, -1, -1):
            board[i][n-1] = board[i+1][n-1] + grid[i][n-1]
        for j in range(n-2, -1, -1):
            board[m-1][j] = board[m-1][j+1] + grid[m-1][j]
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                board[i][j] = min(board[i+1][j], board[i][j+1]) + grid[i][j]
        return board[0][0]

if __name__ == '__main__':
    solution = Solution()
    print solution.minPathSum([[1,3,1],[1,5,1],[4,2,1]])
