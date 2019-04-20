using Algorithms.stack;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Algorithms.Test
{
    public class BalancedBracketsTest
    {
        private IBalancedBracketsSolver _balancedBracketsSolver;

        [SetUp]
        public void Setup()
        {
            _balancedBracketsSolver = new BalancedBracketsSolver();
        }

        [Test]
        [TestCase("{[()]}")]
        [TestCase("{{[[(())]]}}")]
        [TestCase("[](){()}")]
        [TestCase("()")]
        [TestCase("({}([][]))[]()")]
        public void When_BalancedBrackets_Should_ReturnYes(string input)
        {
            Assert.AreEqual("YES", _balancedBracketsSolver.IsBalanced(input));
        }

        [Test]
        [TestCase("{[(])}")]
        [TestCase("}][}}(}][))]")]
        [TestCase("{)[](}]}]}))}(())(")]
        [TestCase("([[)")]
        [TestCase("{(([])[])[]]}")]
        public void When_BalancedNotBrackets_Should_ReturnNo(string input)
        {
            Assert.AreEqual("NO", _balancedBracketsSolver.IsBalanced(input));
        }
    }
}
