package com.xing.tree.order;

import com.xing.tree.TreeNode;
import jdk.jshell.spi.SPIResolutionException;

import java.util.List;

/**
 * @author: Xingweicheng
 * @description: 二叉树前序遍历
 * @date: 2022/11/24 21:46
 */
public class PreOrder {
    private void preOrder(TreeNode root, List<Integer> res){
        if(root==null)
                return;
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}
