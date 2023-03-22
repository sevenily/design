package com.example.demodesigncombin801.mode.vo;

/**
 * 树根信息
 */
public class TreeRoot {
    //规则树ID
    private Long treeId;
    //规则书根ID
    private Long treeRootNodeId;
    //规则树名称
    private String treeName;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }
}
