using System;
using System.Collections.Generic;
namespace Algorithms.backtracking.KnightsTour
{
    public class KnightsTourSolver : IKnightsTourSolver
    {
        private static readonly int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        private static readonly int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

        public int[][] SolveKnightsTour(int rows, int cols)
        {
            if (!IsValidBoardSize(rows, cols))
            {
                throw new ArgumentException("Board size is not valid");
            }

            int[][] board = new int[rows][];

            for (var i = 0; i < board.Length; i++)
            {
                board[i] = new int[cols];
            }

            board[0][0] = 1;

            if (SolveKnightsTour(board, 0, 0, 1))
            {
                PrintBoard(board);
                return board;
            }
            else
            {
                Console.WriteLine("No solution");
                return null;
            }
        }

        private bool IsValidBoardSize(int rows, int cols)
        {
            return rows > 0 && cols > 0;
        }

        private static bool SolveKnightsTour(int[][] board, int x, int y, int moveNum)
        {
            if (moveNum == board.Length * board[0].Length)
                return true;

            for (var i = 0; i < xMove.Length; i++)
            {
                var newX = x + xMove[i];
                var newY = y + yMove[i];

                if (IsValidMove(newX, newY, board))
                {
                    board[newX][newY] = moveNum + 1;

                    if (SolveKnightsTour(board, newX, newY, moveNum + 1))
                    {
                        return true;
                    }
                    else
                    {
                        board[newX][newY] = 0;
                    }
                }
            }

            return false;
        }

        private static bool IsValidMove(int x, int y, int[][] board)
        {
            if (x >= 0 && x < board.Length
                    && y >= 0 && y < board[0].Length
                      && board[x][y] == 0)
                return true;
            return false;
        }

        private static void PrintBoard(int[][] board)
        {
            for (var i = 0; i < board.Length; i++)
            {
                for (var j = 0; j < board[i].Length; j++)
                {
                    Console.Write("{0, -5}", board[i][j]);
                }
                Console.WriteLine();
            }
        }
    }
}
