package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
https://leetcode.com/problems/course-schedule/discuss/261652/BFS-using-HashMap-and-Queue-Java-Very-Easy-To-Understand
TOPOLOGICAL Sort Algo
Time Complexity O(E+V)
SC O(E+V)
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (map.get(prerequisites[i][1]) == null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], tmp);
            } else {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            if (map.get(temp) != null) {
                List<Integer> tempList = map.get(temp);
                for (int num : tempList) {
                    inDegree[num]--;
                    if (inDegree[num] == 0) {
                        queue.add(num);
                    }
                }
            }
        }
        return count == numCourses;
    }
}