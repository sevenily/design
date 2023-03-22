package com.example.demodesigncombin801.service.engine;

import com.example.demodesigncombin801.mode.vo.EngineResult;
import com.example.demodesigncombin801.model.aggregates.TreeRich;

import java.util.Map;

/**
 * 决策引擎接口定义
 */
public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich,
                         final Map<String, String> decisionMatter);

}
