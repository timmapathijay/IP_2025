class Solution {
    public boolean checkBipartite(int startNode , int[][] graph , int[] group)
    {
       Queue<Integer> queue = new LinkedList<>();
       queue.add(startNode);
       group[startNode] = 1;
       while(!queue.isEmpty())
       {
          Integer currVertex = queue.remove();
          // Add adj-nodes if not visited
          for(Integer adjNode : graph[currVertex])
          {
            if(group[adjNode] == 0){
            group[adjNode] = group[currVertex] == 1 ? 2 : 1;
            queue.add(adjNode);
            }
            else if(group[adjNode] == group[currVertex])
            return false;
          }
       }
       return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] group = new int[n];
        // Disconnected Graph [Multiple - Components]
        for(int i = 0 ; i < n ; i++)
        {
            if(group[i] == 0)
            {
                if(checkBipartite(i , graph , group) == false)
                return false;
            }
        }

        return true;
    }
}
// TC : O(V + E)
// SC : O(2V)
