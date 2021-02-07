package Solutions;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        if (root.right == null && root.left ==null && sum == 0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, sum-root.val);
        dfs(root.right, sum-root.val);
        path.pollLast();
    }
}
