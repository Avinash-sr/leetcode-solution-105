class Solution {
    int[] inOrder;
    int[] preOrder;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       this.inOrder = inorder;
       this.preOrder = preorder;
       this.map = new HashMap<>();
        if(preOrder.length != inOrder.length || inOrder == null || preOrder == null){
            return null;
        }

       for(int i=0; i<inOrder.length; i++){
           map.put(inOrder[i], i);
       }
    
    return help(0, inOrder.length-1, 0, preOrder.length-1 );
    }

    public TreeNode help(int instart, int inend, int prestart, int preend){
        if(prestart> preend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[prestart]);
        int ri = map.get(root.val);
        int lst = ri -instart;
        int rst = inend - ri;

        TreeNode left = help(instart, ri-1, prestart+1, prestart+lst);
        TreeNode right = help(ri+1, inend, preend+1-rst, preend );

        root.left = left;
        root.right = right;

        return root;
    }
}