package com.github.weichun97.common.var;

import com.github.weichun97.common.ems.Enums;

/**
 * @author chun
 * @date 2020/9/21
 * @description
 */
public interface YesOrNoVar {

    /**
     * 是否
     */
    int NO = 0;
    int YES = 1;


    Enums SCOPE = Enums.build()
            .add(YES, "是")
            .add(NO, "否");
}
