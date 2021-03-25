package com.github.weichun97.common.var;

import com.github.weichun97.common.ems.Enums;

/**
 * 通用正则表达式
 *
 * @author chun
 * @date 2020/9/17 10:13
 */
public interface PatternVar {

    String WEEK_CYCLE = "^\\d(,\\d)*$";
    String PHONE = "^1\\d{10}$";

    Enums SCOPE = Enums.build()
            .add(WEEK_CYCLE, "周期")
            .add(PHONE, "手机号");
}
