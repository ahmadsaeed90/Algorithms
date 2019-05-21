using Algorithms.graph;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Algorithms.Test
{
    public class NearestCloneSolverTest
    {
        private INearestCloneSolver _nearestCloneSolver;

        public void Setup()
        {
            _nearestCloneSolver = new NearestCloneSolver();
        }

        [SetUp]
        public void When_ValidInput_Should_ReturnShortestDistance_Test1()
        {
            int[] graphFrom = { 1, 1, 4 };
            int[] graphTo = { 2, 3, 2 };
            long[] ids = { 1, 2, 1, 1 };
            int val = 1;

            var result = _nearestCloneSolver.FindShortest(ids.Length, graphFrom, graphTo, ids, val);
            Assert.AreEqual(1, result);
        }

        [SetUp]
        public void When_ValidInput_Should_ReturnShortestDistance_Test2()
        {
            int[] graphFrom = { 1, 1, 4 };
            int[] graphTo = { 2, 3, 2 };
            long[] ids = { 1, 2, 3, 4 };
            int val = 2;

            var result = _nearestCloneSolver.FindShortest(ids.Length, graphFrom, graphTo, ids, val);
            Assert.AreEqual(-1, result);
        }

        [SetUp]
        public void When_ValidInput_Should_ReturnShortestDistance_Test3()
        {
            int[] graphFrom = { 1, 1, 2, 3 };
            int[] graphTo = { 2, 3, 4, 5 };
            long[] ids = { 1, 2, 3, 3, 2 };
            int val = 2;

            var result = _nearestCloneSolver.FindShortest(ids.Length, graphFrom, graphTo, ids, val);
            Assert.AreEqual(3, result);
        }





    }
}
