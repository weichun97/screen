package com.github.weichun97.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author chun
 * @date 2020/9/4
 * @description
 */
@ApiModel(description = "com.github.weichun97.common.page.PageParam")
@Data
public class PageParam implements Serializable {

    private static final long serialVersionUID = 2147028314624861265L;

    @NotNull(message = "显示条数不能为空")
    @ApiModelProperty(value = "每页显示条数", example = "10", required = true)
    private long size = 10;

    @NotNull(message = "当前页不能为空")
    @ApiModelProperty(value = "当前页", example = "1", required = true)
    private long current = 1;

}
