package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class PrimsAlgorithmOrMst {
  /*
      1. Create set of MST that keeps track of vertices already added in MST.
      2. Create Key set to save key value. Initialize all vertices with INFINITY.
           i. Assign Key value ZERO to source node
      3. Do the following until all vertices are not added to MST.
          i.  Pick vertex u which is not in MST and has minimum key value.
          ii. Include u to MST.
          iii.Update key value of all adjacent of u.
               a.) To update key value loop over all adjacents.
                   For each adjacent vertix v,
                   If weight of edge u to v is less than previous key value
                   then update key value as weight of u to v.

   */
}
