package Solutions;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144 树的前序列遍历
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (null != root){
            ans.add(root.val);
            preorder(root.left, ans);
            preorder(root.right, ans);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return ans;
        }
        TreeNode node = root;
        while (!stack.empty() || node!= null){
            while (node != null){
                ans.add(node.val);
                stack.push(root);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }
}
