using Algorithms.array;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Algorithms.Test.array
{
    [TestFixture]
    public class FindPairWithGivenSumTest
    {
        private IFindPairWithGivenSumSolver _findPairWithGivenSumSolver;

        [SetUp]
        public void Setup()
        {
            _findPairWithGivenSumSolver = new FindPairWithGivenSumSolver();
        }

        [Test]
        [TestCase(new int [] {1, 4, 45, 6, 10, -8}, 16)]
        public void When_HasValidSolution_Should_ReturnTrue(int [] arr, int sum)
        {
            Assert.IsTrue(_findPairWithGivenSumSolver.HasPairWithSum(arr, sum));
        }

        [Test]
        [TestCase(new int[] { 1, 4, 45, 6, 10, -8 }, 1000)]
        public void When_HasNoSolution_Should_ReturnFalse(int[] arr, int sum)
        {
            Assert.IsFalse(_findPairWithGivenSumSolver.HasPairWithSum(arr, sum));
        }
    }
}
