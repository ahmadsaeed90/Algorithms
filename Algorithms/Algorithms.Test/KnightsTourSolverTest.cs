using Algorithms.backtracking.KnightsTour;
using NUnit.Framework;
using System;

namespace Tests
{
    public class Tests
    {
        private IKnightsTourSolver _knightsTourSolver;

        [SetUp]
        public void Setup()
        {
            _knightsTourSolver = new KnightsTourSolver();
        }

        [Test]
        [TestCase(0, 0)]
        [TestCase(-1, 1)]
        [TestCase(1, -1)]
        [TestCase(0, 1)]
        [TestCase(1, 0)]
        public void When_BoardSizeInvalid_Should_ReturnError(int rows, int cols)
        {
            Assert.Throws<ArgumentException>(() => { _knightsTourSolver.SolveKnightsTour(rows, cols); });
        }

        [Test]
        public void When_NoSolution_Should_ReturnNull()
        {
            var solution = _knightsTourSolver.SolveKnightsTour(4, 4);
            Assert.IsNull(solution);
        }

        [Test]
        public void When_HasSolution_Should_ReturnSolution()
        {
            var solution = _knightsTourSolver.SolveKnightsTour(5, 5);
            Assert.IsNotNull(solution);
        }

        [Test]
        public void When_HasSolutionForChessBoard_Should_ReturnSolution()
        {
            var solution = _knightsTourSolver.SolveKnightsTour(8, 8);
            Assert.IsNotNull(solution);
        }
    }
}