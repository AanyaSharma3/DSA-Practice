class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int indeg[] = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int[] x:prerequisites){
            adj[x[1]].add(x[0]);
            indeg[x[0]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int c = q.poll();
            count++;
            for(int j:adj[c]){
                if(--indeg[j] == 0){
                    q.add(j);
                }
            }
        }

        return count == numCourses;
    }
}