using Algorithms.graph;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Algorithms.Test
{
    public class RoadsAndLibrariesSolverTest
    {
        private RoadsAndLibrariesSolver _roadsAndLibrariesSolver;

        [SetUp]
        public void Setup()
        {
            _roadsAndLibrariesSolver = new RoadsAndLibrariesSolver();
        }

        [Test]
        public void When_ValidData_Should_ReturnCost_Test1()
        {
            int[][] testCities =
            {
                new int [] { 1, 2 },
                new int [] { 3, 1 },
                new int [] { 2, 3 }
            };

            var cost = _roadsAndLibrariesSolver.RoadsAndLibraries(3, 2, 1, testCities);
            Assert.AreEqual(4, cost);
        }

        [Test]
        public void When_ValidData_Should_ReturnCost_Test2()
        {
            int[][] testCities =
            {
                new int [] { 1, 3 },
                new int [] {3, 4 },
                new int [] {2, 4 },
                new int [] {1, 2 },
                new int [] {2, 3 },
                new int [] {5, 6 }
            };

            var cost = _roadsAndLibrariesSolver.RoadsAndLibraries(6, 2, 5, testCities);
            Assert.AreEqual(12, cost);
        }

        [Test]
        public void When_ValidData_Should_ReturnCost_Test3()
        {
            int[][] testCities =
            {
                new int [] { 8, 2 },
                new int [] { 2, 9 }
            };

            var cost = _roadsAndLibrariesSolver.RoadsAndLibraries(9, 91, 84, testCities);
            Assert.AreEqual(805, cost);
        }

        [Test]
        public void When_ValidData_Should_ReturnCost_Test4()
        {
            int[][] testCities =
            {
                new int [] { 1, 2 },
                new int [] { 2, 4 }
            };

            var cost = _roadsAndLibrariesSolver.RoadsAndLibraries(4, 10, 100, testCities);
            Assert.AreEqual(40, cost);
        }

        [Test]
        public void When_ValidData_Should_ReturnCost_Test5()
        {
            int[][] testCities =
            {
                new int [] { 1, 2 },
                new int [] { 2, 4 }
            };

            var cost = _roadsAndLibrariesSolver.RoadsAndLibraries(4, 10, 100, testCities);
            Assert.AreEqual(40, cost);
        }
    }
}
