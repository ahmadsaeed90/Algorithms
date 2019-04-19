using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.graph
{
    public class RoadsAndLibrariesSolver : IRoadsAndLibrariesSolver
    {
        public long RoadsAndLibraries(int n, int c_lib, int c_road, int[][] cities)
        {
            var visited = new bool[n];
            long cost = 0;

            // build adjancency list to improve performance
            var adjancencyList = new HashSet<int>[n];

            for (var i = 0; i < cities.Length; i++)
            {
                int city1 = cities[i][0] - 1;
                int city2 = cities[i][1] - 1;

                adjancencyList[city1] = adjancencyList[city1] ?? new HashSet<int>();
                adjancencyList[city2] = adjancencyList[city2] ?? new HashSet<int>();

                adjancencyList[city1].Add(city2);
                adjancencyList[city2].Add(city1);
            }

            for (var i = 0; i < visited.Length; i++)
            {
                if (!visited[i])
                {
                    cost += DFS(adjancencyList, c_lib, c_road, visited, i, -1);
                }
            }

            return cost;
        }

        private long DFS(HashSet<int>[] adjacencyList, int c_lib, int c_road, bool[] visited, int currentCity, int parent)
        {
            long cost = parent == -1 ? c_lib : Math.Min(c_lib, c_road);
            visited[currentCity] = true;

            var nextCities = adjacencyList[currentCity];

            if (nextCities != null)
            {
                foreach (var city in nextCities)
                {
                    if (!visited[city])
                    {
                        cost += DFS(adjacencyList, c_lib, c_road, visited, city, currentCity);
                    }
                }
            }

            return cost;
        }
    }
}
