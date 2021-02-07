package Solutions;

import DataStructure.TreeNode;

import java.util.Stack;

/**
 * 112. 路径总和
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        class StackNode{
            TreeNode node;
            int sum;
            StackNode(TreeNode node, int sum){
                this.node = node;
                this.sum = sum;
            }
        }
        Stack<StackNode> stack = new Stack<>();
        if (null == root){
            return false;
        }
        stack.push(new StackNode(root, root.val));
        while (!stack.isEmpty()){
            StackNode top = stack.pop();
            TreeNode treeNode = top.node;
            int nowSum = top.sum;
            if (treeNode.right == null && treeNode.left == null && sum == nowSum){
                return true;
            }
            if (treeNode.left != null){
                stack.push(new StackNode(treeNode.left, nowSum+treeNode.left.val));
            }
            if (treeNode.right != null){
                stack.push(new StackNode(treeNode.right, nowSum+treeNode.right.val));
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum){
        if (null == root){
            return false;
        }
        if (root.right == null && root.left==null){
            return root.val == sum;
        }
        return hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum-root.val);
    }
}
