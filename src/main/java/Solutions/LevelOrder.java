package Solutions;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层序遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentSize = queue.size();
            for (int i=1;i<=currentSize;i++){
                TreeNode queueHead = queue.poll();
                level.add(queueHead.val);
                if (queueHead.left!=null){
                    queue.add(queueHead.left);
                }
                if (queueHead.right!=null){
                    queue.add(queueHead.right);
                }
            }
            if (!level.isEmpty()){
                res.add(level);
            }
        }
        return res;
    }

    /**
     * 103,锯齿形遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentSize = queue.size();
            List<TreeNode> nodeList = new ArrayList<>();
            for (int i=1;i<=currentSize;i++) {
                nodeList.add(0, queue.poll());
            }
            for (TreeNode queueHead:nodeList
                 ) {
                level.add(queueHead.val);
                if (count%2==1){
                    if (queueHead.right!=null){
                        queue.add(queueHead.right);
                    }
                    if (queueHead.left!=null){
                        queue.add(queueHead.left);
                    }
                }else {
                    if (queueHead.left!=null){
                        queue.add(queueHead.left);
                    }
                    if (queueHead.right!=null){
                        queue.add(queueHead.right);
                    }
                }
            }
            ++count;
            if (!level.isEmpty()){
                res.add(level);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        Integer[] integers = new Integer[]{1,2,null,3,null,4,null,5};
        TreeNode root = TreeNode.bulidTree(integers);
        levelOrder.levelOrder(root);
    }
}
