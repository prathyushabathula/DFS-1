// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// //BFS
// class FloodFill {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int m = image.length;
//         int n = image[0].length;
//         if(image[sr][sc] == color) return image;
//         int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//         Queue<Integer> q = new LinkedList<>();
//         int previousColor = image[sr][sc];
//         q.add(sr);
//         q.add(sc);
//         image[sr][sc] = color;

//         while(!q.isEmpty()) {
//             int r = q.poll();
//             int c = q.poll();
//             for(int[] dir: dirs) {
//                 int nr = r+dir[0];
//                 int nc = c+dir[1];
//                 if(nr>=0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == previousColor) {
//                     q.add(nr);
//                     q.add(nc);
//                     image[nr][nc] = color;
//                 }
//             } 
//         }
//         return image;

//     }
// }
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class FloodFill {
    int m;
    int n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m = image.length;
        this.n = image[0].length;
        if(image[sr][sc] == color) return image;
        this.dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int previousColor = image[sr][sc];
        dfs(image, sr, sc, color, previousColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int previousColor) {
        image[r][c] = color;
        for(int[] dir : dirs) {
            int nr = r+dir[0];
            int nc = c+dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == previousColor) {
                dfs(image, nr, nc, color, previousColor);
            } 
        }
    }
}