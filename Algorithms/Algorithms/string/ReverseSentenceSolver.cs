using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms
{
    class ReverseSentenceSolver
    {
        public string ReverseSentence(string s)
        {
            if (string.IsNullOrWhiteSpace(s))
                return s;

            var cArray = s.ToCharArray();

            Reverse(cArray, 0, cArray.Length - 1);

            int start = -1;

            for (int i = 0; i < cArray.Length; i++)
            {
                if (cArray[i] == ' ' && start != -1)
                {
                    Reverse(cArray, start, i - 1);
                    start = -1;
                }
                else if (cArray[i] != ' ' && start == -1)
                {
                    start = i;
                }
            }

            if (start != -1)
                Reverse(cArray, start, cArray.Length - 1);

            return new string(cArray);
        }

        private void Reverse(char [] cArray, int start, int end)
        {
            int length = end - start + 1;

            for (int i = 0; i < length / 2; i++)
            {
                var x = start + i;
                var y = end - i;

                var temp = cArray[x];
                cArray[x] = cArray[y];
                cArray[y] = temp;
            }
           
        }
    }
}
