// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//BFS
class 01Matrix {
    int m;
    int n;
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                } 
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i,j});
                } 
            }
        }
        int dist = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0; k< size; k++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr >= 0 && nr < m && nc >=0 && nc < n && mat[nr][nc] == -1) {
                        queue.add(new int[]{nr,nc});
                        mat[nr][nc] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
//DFS
class 01Matrix {
    int m;
    int n;
    int[][] result;
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.result = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    result[i][j] = dfs(mat, i, j);
                }
            }
        }
        return result;
    }
    private int dfs(int[][] mat, int i, int j) {
        if(i > 0 && mat[i-1][j] == 0) return 1;
        if(j > 0 && mat[i][j-1] == 0) return 1;
        if(i < m-1 && mat[i+1][j] == 0) return 1;
        if(j < n-1 && mat[i][j+1] == 0) return 1;

        int top=9999,left = 9999, bottom = 9999, right = 9999;

        if(i > 0 && result[i-1][j] != 0) {
            top = result[i-1][j];
        }
        if(j > 0 && result[i][j-1] != 0) {
            left = result[i][j-1];
        }
        if(i < m-1) {
            if(result[i+1][j] == 0) {
                result[i+1][j] = dfs(mat, i+1, j);
            }
            bottom = result[i+1][j];
        }
        if(j < n-1) {
            if(result[i][j+1] == 0) {
                result[i][j+1] = dfs(mat, i, j+1);
            }
            right = result[i][j+1];
        }
        return 1+Math.min(top, Math.min(left, Math.min(bottom, right)));

    }
}