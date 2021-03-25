package com.github.weichun97.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author chun
 * @date 2020/12/2
 * @description 公式计算
 */
@Slf4j
public class FormulaUtil {


    public static ScriptEngine getScriptEngine(Map<String, BigDecimal> map) {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("js");
        if (!CollectionUtils.isEmpty(map)) {
            map.forEach((k, v) -> scriptEngine.put(k, v.doubleValue()));

        }


        return scriptEngine;
    }


    public static BigDecimal execute(ScriptEngine scriptEngine, String formula) {

        try {
            Object result = scriptEngine.eval(formula);
            if (result instanceof Double) {
                return new BigDecimal((Double) result);
            } else if (result instanceof Integer) {
                return new BigDecimal((Integer) result);
            } else if (result instanceof BigDecimal) {
                return (BigDecimal) result;
            } else {
                return null;
            }

        } catch (ScriptException e) {
            log.error("公式解析错误:" + formula);
            return null;
        }
    }


}
