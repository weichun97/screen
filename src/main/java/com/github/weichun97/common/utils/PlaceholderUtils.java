package com.github.weichun97.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author chun
 * @date 2020/8/25
 * @description 占位符替换工具
 */
@Slf4j
public class PlaceholderUtils {

    /**
     * 占位符前缀
     */
    public static final String PLACEHOLDER_PREFIX = "${";
    /**
     * 占位符后缀
     */
    public static final String PLACEHOLDER_SUFFIX = "}";

    public static String resolvePlaceholders(String text, Map<String, String> parameter) {

        if (parameter == null || parameter.isEmpty()) {
            return text;
        }
        StringBuffer buf = new StringBuffer(text);
        int startIndex = buf.indexOf(PLACEHOLDER_PREFIX);
        while (startIndex != -1) {
            int endIndex = buf.indexOf(PLACEHOLDER_SUFFIX, startIndex + PLACEHOLDER_PREFIX.length());
            if (endIndex != -1) {
                String placeholder = buf.substring(startIndex + PLACEHOLDER_PREFIX.length(), endIndex);
                int nextIndex = endIndex + PLACEHOLDER_SUFFIX.length();
                try {
                    String propVal = parameter.get(placeholder);
                    if (propVal == null) {
                        propVal = "";
                    }
                    buf.replace(startIndex, endIndex + PLACEHOLDER_SUFFIX.length(), propVal);
                    nextIndex = startIndex + propVal.length();
                } catch (Exception ex) {
                    log.warn("无法解析占位符 '" + placeholder + "' in [" + text + "]: " + ex);
                }
                startIndex = buf.indexOf(PLACEHOLDER_PREFIX, nextIndex);
            } else {
                startIndex = -1;
            }
        }
        return buf.toString();

    }
}