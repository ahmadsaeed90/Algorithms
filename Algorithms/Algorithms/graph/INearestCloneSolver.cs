using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.graph
{
    public interface INearestCloneSolver
    {
        int FindShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val);
    }
}
