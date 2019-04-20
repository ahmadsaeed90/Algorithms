using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms.stack
{
    public class BalancedBracketsSolver: IBalancedBracketsSolver
    {
        public string IsBalanced(string s)
        {
            Stack<char> stack = new Stack<char>();

            for (var i = 0; i < s.Length; i++)
            {
                char c = s[i];

                if (c == '{' || c == '[' || c == '(')
                {
                    stack.Push(c);
                }
                else if (c == '}')
                {
                    if (stack.Count > 0 && stack.Peek() == '{')
                    {
                        stack.Pop();
                    }
                    else
                        return "NO";
                }
                else if (c == ']')
                {
                    if (stack.Count > 0 && stack.Peek() == '[')
                    {
                        stack.Pop();
                    }
                    else
                        return "NO";
                }
                else if (c == ')')
                {
                    if (stack.Count > 0 && stack.Peek() == '(')
                    {
                        stack.Pop();
                    }
                    else
                        return "NO";
                }
            }

            if (stack.Count == 0)
            {
                return "YES";
            }
            return "NO";
        }
    }
}
