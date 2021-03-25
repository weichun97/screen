package com.github.weichun97.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Data
@TableName("device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Long id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 删除时间
     */
    @TableField(value = "delete_time")
    @TableLogic(value = "0", delval = "UNIX_TIMESTAMP()")
    private Long deleteTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;


}
