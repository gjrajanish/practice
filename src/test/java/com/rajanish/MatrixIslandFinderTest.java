package com.rajanish;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by rajanish on 16/10/16.
 */
public class MatrixIslandFinderTest {

    @DataProvider(name = "testDataDebug")
    public Object[][] testDataProviderDebug() {
        return new Object[][]{
                {
                        "all ones",
                        new String[][]{
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"}
                        },
                        1
                },

        };
    }
    @DataProvider(name = "testData")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {
                        "happy path test",
                        new String[][]{
                                {"1", "0", "1", "1"},
                                {"0", "0", "0", "0"},
                                {"1", "0", "0", "1"},
                                {"0", "1", "0", "0"}
                        },
                        5
                },
                {
                        "single island",
                        new String[][]{
                                {"1", "0", "1", "1"},
                                {"1", "1", "0", "1"},
                                {"1", "1", "0", "1"},
                                {"0", "1", "1", "1"}
                        },
                        1
                }, {
                "no island",
                new String[][]{
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"}
                },
                0
        }, {
                "one island",
                new String[][]{
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                        {"0", "1", "0", "0"},
                        {"0", "0", "0", "0"}
                },
                1
        }, {
                "corner one island",
                new String[][]{
                        {"1", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"}
                },
                1
        }, {
                "all corners island",
                new String[][]{
                        {"1", "0", "0", "1"},
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                        {"1", "0", "0", "1"}
                },
                4
        },
                {
                        "all ones",
                        new String[][]{
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"},
                                {"1", "1", "1", "1"}
                        },
                        1
                },
                {
                        "single column - one island",
                        new String[][]{
                                {"1", "1", "1", "1"}
                        },
                        1
                },
                {
                        "single column - two island",
                        new String[][]{
                                {"1", "1", "0", "1"}
                        },
                        2
                },
                {
                        "single column - no island",
                        new String[][]{
                                {"0", "0", "0", "0"}
                        },
                        0
                },
                {
                        "single row - no island",
                        new String[][]{
                                {"0"}, {"0"}, {"0"}, {"0"}
                        },
                        0
                }
                ,
                {
                        "single row - no island",
                        new String[][]{
                                {"0"}, {"0"}, {"0"}, {"0"}
                        },
                        0
                }
        };
    }

    @Test(dataProvider = "testData")
    public void testDepthFirst(String desc, String matrix[][], Integer expected) {
        MatrixIslandFinder matrixIslandFinder = new MatrixIslandFinder();
        Integer noOfIslands = matrixIslandFinder.countIslandsDepthFirst(matrix);
        Assert.assertEquals(noOfIslands, expected, desc);
    }

    @Test(dataProvider = "testData")
    public void test(String desc, String matrix[][], Integer expected) {
        MatrixIslandFinder matrixIslandFinder = new MatrixIslandFinder();
        Integer noOfIslands = matrixIslandFinder.countIslands(matrix);
        Assert.assertEquals(noOfIslands, expected, desc);
    }
}
