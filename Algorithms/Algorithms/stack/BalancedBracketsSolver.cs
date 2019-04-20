using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.stack
{
    public class BalancedBracketsSolver : IBalancedBracketsSolver
    {
        public string IsBalanced(string s)
        {
            var stack = new Stack<char>();

            foreach (var c in s)
            {
                if (c == '{' || c == '[' || c == '(')
                {
                    stack.Push(c);
                }
                else if (c == '}' && stack.Count > 0 && stack.Peek() == '{')
                {
                    stack.Pop();
                }
                else if (c == ']' && stack.Count > 0 && stack.Peek() == '[')
                {
                    stack.Pop();
                }
                else if (c == ')' && stack.Count > 0 && stack.Peek() == '(')
                {
                    stack.Pop();
                }
                else
                    return "NO";
            }

            return stack.Count == 0 ? "YES" : "NO";
        }
    }
}
