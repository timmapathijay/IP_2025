class Solution {
    public void bfsTraversal(int startNode , ArrayList<ArrayList<Integer>> adj , 
    boolean[] visited , ArrayList<Integer> bfs)
    {
       Queue<Integer> queue = new LinkedList<>();
       queue.add(startNode);
       visited[startNode] = true;
       
       while(!queue.isEmpty())
       {
           Integer currVertex = queue.remove();
           bfs.add(currVertex);
           // Add Neighbouring vertex if they are not visited
           for(Integer adjVertex : adj.get(currVertex))
           {
               if(visited[adjVertex] == false)
               {
                   queue.add(adjVertex);
                   visited[adjVertex] = true;
               }
           }
       } 
    }
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] visited = new boolean[V];    
       ArrayList<Integer> bfs = new ArrayList<>();
        //Multiple Graph Components
       for(int i = 0 ; i < V ; i++)
       {
          if(visited[i] == false)
          bfsTraversal(i , adj , visited , bfs);
       }
       
       return bfs;
    }
}
// TC : O(V + E)
// SC : O(2V)
