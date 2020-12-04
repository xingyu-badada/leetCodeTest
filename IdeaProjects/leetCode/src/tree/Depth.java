package tree;

public class Depth {


    public static void main(String[] args) {
        //构建树：
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode treeNode = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        treeNode.left =leftNode;
        TreeNode rightNode = new TreeNode(20);
        TreeNode subLeft = new TreeNode(15);
        TreeNode subRight = new TreeNode(7);
        rightNode.left = subLeft;
        rightNode.right = subRight;
        treeNode.right = rightNode;
        System.out.println(maxDepth(treeNode));
    }


    public static int maxDepth(TreeNode root) {
        //树的深度，左子树的深度和右子树的深度中，更大的值 +1
        //判断如果为空，直接返回0
        if (root ==null) return 0;
        //利用递归，
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //Math.max(a,b)  比较括号内的值，返回大的值。
        return Math.max(leftDepth,rightDepth)+1;
    }
}
