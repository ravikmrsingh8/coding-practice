package org.example.graph;

class NumIslands {
    public int numIslands(char[][] grid) {
        //IslandsBFS islandsByBFS = new IslandsBFS(grid);
        //return islandsByBFS.count();

        IslandsDFS islandsByDFS = new IslandsDFS(grid);
        return islandsByDFS.count();
    }
}


