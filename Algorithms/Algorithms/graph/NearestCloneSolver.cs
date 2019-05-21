using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.graph
{
    public class NearestCloneSolver : INearestCloneSolver
    {
        public int FindShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val)
        {
            var adjancencyList = BuildAdjancencyList(graphNodes, graphFrom, graphTo);
            var shortestPaths = new int[graphNodes];

            for (var i = 0; i < shortestPaths.Length; i++)
            {
                shortestPaths[i] = int.MaxValue;
            }

            for (var i = 0; i < graphNodes; i++)
            {
                Dijkstra(i, adjancencyList, shortestPaths);
            }

            // solve here
            return 0;
        }

        private void Dijkstra(int currentNode, HashSet<int>[] adjancencyList, int[] shortestPaths)
        {

        }

        private HashSet<int>[] BuildAdjancencyList(int graphNodes, int[] graphFrom, int[] graphTo)
        {
            var adjancencyList = new HashSet<int>[graphNodes];

            for (int i = 0; i < graphFrom.Length; i++)
            {
                int from = graphFrom[i];
                int to = graphTo[i];

                adjancencyList[from - 1].Add(to - 1);
                adjancencyList[to - 1].Add(from - 1);
            }

            return adjancencyList;
        }
    }
}
