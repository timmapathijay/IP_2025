/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Node {
    TreeNode node;
    int row;
    int col;
    Node(TreeNode node , int row , int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class SortbyVerticalOrder implements Comparator<Node>{
    public int compare(Node a , Node b){
        if(a.row == b.row && a.col == b.col)
        return a.node.val - b.node.val;
        else
        return a.row - b.row;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalOrderTraversal = new ArrayList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        int rightMostVerticalLine = 0;
        int leftMostVerticalLine = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root , 0 , 0));
        while(!queue.isEmpty()){
            Node currNode = queue.remove();
            rightMostVerticalLine  = Math.max(rightMostVerticalLine , currNode.col);
            leftMostVerticalLine = Math.min(leftMostVerticalLine , currNode.col);

            if(currNode.node.left != null)
            queue.add(new Node(currNode.node.left , currNode.row + 1 , currNode.col - 1));

            if(currNode.node.right != null)
            queue.add(new Node(currNode.node.right , currNode.row + 1 , currNode.col + 1));

            if(!map.containsKey(currNode.col)){
                List<Node> verticalOrderList = new ArrayList<>();
                verticalOrderList.add(currNode); 
                map.put(currNode.col , verticalOrderList);
            }else{
                map.get(currNode.col).add(currNode);
            }
        }

        for(int i = leftMostVerticalLine; i <= rightMostVerticalLine; i++){
            List<Node> nodesList = map.get(i);
            Collections.sort(nodesList , new SortbyVerticalOrder());
            List<Integer> verticalOrderList = new ArrayList<>();
            for(Node currNode : nodesList){
                verticalOrderList.add(currNode.node.val);
            }
            verticalOrderTraversal.add(verticalOrderList);
        }
        return verticalOrderTraversal;
    }
}
