package com.vamshi.coding;

import com.vamshi.coding.dpseries.grid.DP9_GridUniquePaths_Obstacles_Recursion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
*
* 5
5 9
0 -1 0 0 -1 0 0 0 0
-1 0 0 0 0 -1 -1 0 0
0 0 0 -1 -1 0 0 0 0
-1 0 -1 0 0 0 0 0 -1
-1 0 0 0 0 0 -1 -1 0
8 6
0 0 -1 0 0 0
-1 0 0 0 -1 0
0 0 0 0 0 0
0 -1 0 0 0 0
-1 -1 0 -1 -1 0
0 0 -1 -1 0 0
0 0 0 -1 0 0
0 0 -1 0 -1 0
14 12
0 0 0 0 0 0 0 0 -1 0 -1 0
0 0 -1 0 0 0 0 -1 -1 0 0 0
0 -1 -1 0 0 -1 0 -1 0 0 0 -1
-1 0 -1 0 0 -1 0 0 -1 0 -1 -1
0 -1 0 0 0 0 0 0 -1 0 0 0
-1 -1 0 0 0 0 -1 -1 -1 -1 0 0
0 0 0 -1 -1 0 0 -1 0 0 0 0
0 -1 -1 -1 0 0 0 -1 0 0 0 -1
-1 0 0 -1 -1 -1 0 0 0 0 0 0
0 0 -1 0 0 -1 -1 0 0 -1 -1 -1
-1 0 0 -1 0 0 0 -1 0 0 0 0
-1 0 0 0 0 -1 -1 0 -1 0 0 0
0 0 0 -1 0 0 -1 0 0 0 0 0
0 0 0 0 -1 0 0 0 0 0 0 0
15 12
0 0 -1 0 0 -1 -1 0 -1 -1 0 0
0 0 -1 0 0 -1 0 0 0 0 0 0
-1 -1 -1 -1 0 0 0 0 0 0 0 0
-1 -1 0 0 -1 0 0 0 0 -1 0 0
0 -1 -1 -1 -1 0 0 0 0 -1 0 0
0 0 0 -1 0 0 -1 0 -1 -1 0 0
0 0 0 0 -1 0 0 0 -1 0 -1 -1
-1 0 -1 -1 0 0 -1 0 -1 -1 0 0
0 0 0 0 -1 0 0 0 -1 -1 0 0
-1 0 -1 0 -1 -1 0 0 0 0 -1 0
0 0 -1 0 -1 0 -1 0 0 0 0 0
0 -1 -1 0 -1 -1 0 -1 0 0 0 -1
0 0 0 -1 0 0 0 -1 0 -1 0 -1
0 0 -1 -1 0 -1 0 -1 0 -1 -1 -1
0 0 0 -1 -1 -1 0 -1 0 -1 0 0
4 14
0 0 0 0 -1 0 0 -1 -1 -1 -1 0 0 -1
0 0 0 -1 -1 -1 0 0 0 0 0 0 -1 -1
0 0 0 0 0 0 0 -1 0 0 -1 -1 0 0
0 0 0 0 0 -1 0 0 0 0 -1 -1 0 0

*
* */


@SpringBootTest
class DP9_GridUniquePaths_Obstacles_Recursion_Tests {

	@Test
	void contextLoads() {

		ArrayList<List<Integer>> maze = new ArrayList<>();

		maze.add(List.of(0, -1, 0, 0, -1, 0, 0, 0, 0 ));
		maze.add(List.of(-1, 0, 0, 0, 0, -1, -1, 0, 0 ));
		maze.add(List.of(0, 0, 0, -1, -1, 0, 0, 0, 0 ));
		maze.add(List.of(-1, 0, -1, 0, 0, 0, 0, 0, -1 ));
		maze.add(List.of(-1, 0, 0, 0, 0, 0, -1, -1, 0 ));

		int m = maze.size();
		int n = maze.get(0).size();

		int[][] dp = new int[m][n];

		for(int[] row: dp){
			Arrays.fill(row, -1);
		}

		System.out.println("result is " + DP9_GridUniquePaths_Obstacles_Recursion.countWays(m-1, n-1, maze, dp));


	}
	@Test
	void test2() {

		ArrayList<List<Integer>> maze = new ArrayList<>();

		maze.add(List.of(0, 0, -1, 0, 0, 0));
		maze.add(List.of(-1, 0, 0, 0, -1, 0 ));
		maze.add(List.of(0, 0, 0, 0, 0, 0 ));
		maze.add(List.of(0, -1, 0, 0, 0, 0));
		maze.add(List.of(-1, -1, 0, -1, -1, 0));

		maze.add(List.of(0, 0, -1, -1, 0, 0));
		maze.add(List.of(0, 0, 0, -1, 0, 0));
		maze.add(List.of(0, 0, -1, 0, -1, 0));

		int m = maze.size();
		int n = maze.get(0).size();

		int[][] dp = new int[m][n];

		for(int[] row: dp){
			Arrays.fill(row, -1);
		}

		System.out.println("result is " + DP9_GridUniquePaths_Obstacles_Recursion.countWays(m-1, n-1, maze, dp));


	}

	@Test
	void test3() {

		ArrayList<List<Integer>> maze = new ArrayList<>();

		maze.add(List.of(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0));
		maze.add(List.of(0, 0, -1, 0, 0, 0, 0, -1, -1, 0, 0, 0));
		maze.add(List.of(0, -1, -1, 0, 0, -1, 0, -1, 0, 0, 0, -1));
		maze.add(List.of(-1, 0, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1));
		maze.add(List.of(0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0));
		maze.add(List.of(-1, -1, 0, 0, 0, 0, -1, -1, -1, -1, 0, 0));
		maze.add(List.of(0, 0 ,0, -1, -1, 0, 0, -1, 0, 0, 0, 0));
		maze.add(List.of(0, -1, -1, -1, 0, 0, 0, -1, 0, 0, 0, -1));
		maze.add(List.of(-1, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0));
		maze.add(List.of(0, 0, -1, 0, 0, -1, -1, 0, 0, -1, -1, -1));
		maze.add(List.of(-1, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0));
		maze.add(List.of(-1, 0, 0, 0, 0, -1, -1, 0, -1, 0, 0, 0));
		maze.add(List.of(0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0));
		maze.add(List.of(0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0));

		int m = maze.size();
		int n = maze.get(0).size();

		int[][] dp = new int[m][n];

		for(int[] row: dp){
			Arrays.fill(row, -1);
		}

		System.out.println("result is " + DP9_GridUniquePaths_Obstacles_Recursion.countWays(m-1, n-1, maze, dp));



	}
	@Test
	void test4() {

		ArrayList<List<Integer>> maze = new ArrayList<>();


		maze.add(List.of(0, 0, -1, 0, 0, -1, -1, 0, -1, -1, 0, 0));
		maze.add(List.of(0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0));
		maze.add(List.of(-1, 0, -1, -1, 0, 0, -1, 0, -1, -1, 0, 0));
		maze.add(List.of(0, 0, 0, 0, -1, 0, 0, 0, -1, -1, 0, 0));
		maze.add(List.of(-1, 0, -1, 0, -1, -1, 0, 0, 0, 0, -1, 0));

		maze.add(List.of(0, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, 0));
		maze.add(List.of(0, 0, 0, 0, -1, 0, 0, 0, -1, 0, -1, -1));
		maze.add(List.of(0, -1, -1, -1, 0, 0, 0, -1, 0, 0, 0, -1));
		maze.add(List.of(-1, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0));
		maze.add(List.of(0, 0, -1, 0, 0, -1, -1, 0, 0, -1, -1, -1));

		maze.add(List.of(0, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0));
		maze.add(List.of(0, -1, -1, 0, -1, -1, 0, -1, 0, 0, 0, -1));
		maze.add(List.of(0, 0, 0, -1, 0, 0, 0, -1, 0, -1, 0, -1));
		maze.add(List.of(0, 0, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1));
		maze.add(List.of(0, 0, 0, -1, -1, -1, 0, -1, 0, -1, 0, 0));

		int m = maze.size();
		int n = maze.get(0).size();

		int[][] dp = new int[m][n];

		for(int[] row: dp){
			Arrays.fill(row, -1);
		}

		System.out.println("result is " + DP9_GridUniquePaths_Obstacles_Recursion.countWays(m-1, n-1, maze, dp));

	}

	@Test
	void test5() {

		ArrayList<List<Integer>> maze = new ArrayList<>();

		maze.add(List.of(0, 0, 0, 0, -1, 0, 0, -1, -1, -1, -1, 0, 0, -1));
		maze.add(List.of(0, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, -1, -1));
		maze.add(List.of(0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0));
		maze.add(List.of(0, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, 0, 0));

		int m = maze.size();
		int n = maze.get(0).size();

		int[][] dp = new int[m][n];

		for(int[] row: dp){
			Arrays.fill(row, -1);
		}

		System.out.println("result is " + DP9_GridUniquePaths_Obstacles_Recursion.countWays(m-1, n-1, maze, dp));

	}

}
