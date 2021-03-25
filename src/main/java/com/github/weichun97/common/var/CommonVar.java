package com.github.weichun97.common.var;

import com.github.weichun97.common.ems.Enums;

/**
 * 公用常量
 */
public interface CommonVar {

    String SYSTEM = "系统";
    String CENTER = "center";
    String CURRENT_HARBOR = "SK";
    String DICT_TEXT_SUFFIX = "DictValue";

    Enums SCOPE = Enums.build()
            .add(SYSTEM, "系统")
            .add(CENTER, "中心系统")
            .add(CURRENT_HARBOR, "当前港口")
            .add(DICT_TEXT_SUFFIX, "字典字段后缀");
}
