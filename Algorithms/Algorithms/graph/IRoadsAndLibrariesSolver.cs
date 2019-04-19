using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.graph
{
    /// <summary>
    /// https://www.hackerrank.com/challenges/torque-and-development/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
    /// </summary>
    interface IRoadsAndLibrariesSolver
    {
        long RoadsAndLibraries(int n, int c_lib, int c_road, int[][] cities);
    }
}
