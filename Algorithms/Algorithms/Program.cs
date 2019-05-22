using Algorithms.backtracking;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(new ReverseSentenceSolver().ReverseSentence("you shall not pass"));
            Console.WriteLine(new ReverseSentenceSolver().ReverseSentence("geeks quiz practice code"));
        }
    }
}
