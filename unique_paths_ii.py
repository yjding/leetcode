class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        if not m: return 0
        n = len(obstacleGrid[0])
        if not n: return 0
        board = []
        for i in range(m):
            row = list()
            for i in range(n):
                row.append(0)
            board.append(row)
        board[m-1][n-1] = 1 if obstacleGrid[m-1][n-1] != 1 else 0
        for i in range(m-2, -1, -1):
            board[i][n-1] = board[i+1][n-1] if obstacleGrid[i][n-1] != 1 else 0
        for j in range(n-2, -1, -1):
            board[m-1][j] = board[m-1][j+1] if obstacleGrid[m-1][j] != 1 else 0
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                board[i][j] = board[i+1][j] + board[i][j+1] if obstacleGrid[i][j] != 1 else 0
        return board[0][0]
