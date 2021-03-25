package com.github.weichun97.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * bean转json格式或者json转bean格式, 项目中我们通常使用这个工具类进行json---java互相转化
 */
public class JacksonUtil {
    public static ObjectMapper mapper = new ObjectMapper();
}