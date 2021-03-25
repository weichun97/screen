package com.github.weichun97.common.utils;

import org.springframework.lang.Nullable;

/**
 * The type String utils.
 *
 * @author chun
 * @date 2020 /11/3 18:08
 */
public class StringUtils {

    /**
     * int 转换成 string, 如果为 null 则转换成 null
     *
     * @param i the
     * @return the string
     */
    @Nullable
    public static String integerToStr(Integer i) {
        return i == null ? null : i.toString();
    }
}
