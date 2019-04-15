using Algorithms.backtracking.KnightsTour;
using NUnit.Framework;
using System;

namespace Tests
{
    public class Tests
    {
        private IKnightsTourSolver _knightsTour;

        [SetUp]
        public void Setup()
        {
            _knightsTour = new KnightsTourSolver();
        }

        [Test]
        [TestCase(0, 0)]
        [TestCase(-1, 1)]
        [TestCase(1, -1)]
        [TestCase(0, 1)]
        [TestCase(1, 0)]
        public void When_BoardSizeInvalid_Should_ReturnError(int rows, int cols)
        {
            Assert.Throws<ArgumentException>(() => { _knightsTour.SolveKnightsTour(rows, cols); });
        }

    }
}