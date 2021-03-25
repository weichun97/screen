package com.github.weichun97.entity.vo.device;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chun
 * @date 2020/9/4
 * @description 
 */
@Data
@ApiModel(value = "com.github.weichun97.entity.vo.device.DeviceVO")
public class DeviceVO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", example = "")
    private Long id;

    @ApiModelProperty(value = "名称", example = "")
    private String name;

    @ApiModelProperty(value = "地址", example = "")
    private String url;

    @ApiModelProperty(value = "备注", example = "")
    private String remark;

    @ApiModelProperty(value = "删除时间", example = "")
    private Integer deleteTime;

    @ApiModelProperty(value = "创建时间", example = "")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "")
    private Date updateTime;

}