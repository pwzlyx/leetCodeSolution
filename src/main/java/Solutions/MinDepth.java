package Solutions;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if (null == root){
            return 0;
        }
        if (root.right == null && root.left==null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null){
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null){
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth+1;
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root){
        if (null == root){
            return 0;
        }

        class QueueNode{
            TreeNode node;
            Integer depth;

            QueueNode(TreeNode node, int depth){
                this.node = node;
                this.depth = depth;
            }
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i=0;i<currentSize;i++){
                QueueNode queueHead = queue.poll();
                int depth = queueHead.depth;
                TreeNode treeNode = queueHead.node;
                if (treeNode.left == null && treeNode.right == null){
                    return depth;
                }
                if (treeNode.left != null){
                    queue.offer(new QueueNode(treeNode.left, depth+1));
                }
                if (treeNode.right != null){
                    queue.offer(new QueueNode(treeNode.right, depth+1));
                }
            }
        }
        return 0;
    }
}
