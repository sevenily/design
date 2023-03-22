package com.example.demodesigncombin801.service.engine.impl;

import com.example.demodesigncombin801.mode.vo.EngineResult;
import com.example.demodesigncombin801.mode.vo.TreeNode;
import com.example.demodesigncombin801.model.aggregates.TreeRich;
import com.example.demodesigncombin801.service.engine.EngineBase;

import java.util.Map;

/**
 * 决策引擎的实现
 */
public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        //决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);

        //决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
