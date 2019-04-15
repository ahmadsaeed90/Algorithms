namespace Algorithms.backtracking.KnightsTour
{
    public interface IKnightsTourSolver
    {
        /// <summary>
        /// Solve Knight's tour problem on given board size.
        /// </summary>
        /// <param name="rows"></param>
        /// <param name="cols"></param>
        /// <returns>Board if problem solved, null if no solution</returns>
        int[][] SolveKnightsTour(int rows, int cols);
    }
}
