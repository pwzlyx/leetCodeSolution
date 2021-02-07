package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //二叉树生成装置
    public static TreeNode bulidTree(Integer[] nums){
        if (nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        for (int i=1;i < nums.length;i++){
            TreeNode node = queue.peek();
            if (null != nums[i]){
                TreeNode newNode = new TreeNode(nums[i]);
                if (count==0){
                    node.left = newNode;
                }else {
                    node.right = newNode;
                }
                queue.add(newNode);
            }
            count = (count+1)%2;
            if (count == 0){
                queue.poll();
            }
        }
        return root;
    }
}
