package com.github.weichun97.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author wxp
 * @date 2020/12/29 17:39
 * @description DoubleUtils
 */
public class DoubleUtils {

    /**
     * 保留两位小数
     *
     * @param target
     * @return
     */
    public static double keepTwoDecimal(double target) {
        BigDecimal bg = new BigDecimal(target).setScale(2, RoundingMode.UP);
        return bg.doubleValue();
    }
}
