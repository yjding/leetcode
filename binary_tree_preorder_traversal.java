/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayDeque;
import java.util.HashSet;

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        ArrayList<Integer> results = new ArrayList<Integer>();
        
        TreeNode currNode = root;
        while(currNode!=null){
            if(!set.contains(currNode)){
                results.add(currNode.val);
                set.add(currNode);
            }
            if(currNode.left!=null&&!set.contains(currNode.left)){
                stack.push(currNode);
                currNode = currNode.left;
            }
            else if(currNode.right!=null&&!set.contains(currNode.right)){
                stack.push(currNode);
                currNode = currNode.right;
            }
            else{
                if(stack.isEmpty())
                    break;
                currNode = stack.pop();
            }
        }
        return results;
    }
}
