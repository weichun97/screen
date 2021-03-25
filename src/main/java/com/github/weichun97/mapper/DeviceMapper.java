package com.github.weichun97.mapper;

import com.github.weichun97.common.page.FgocPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.github.weichun97.entity.param.device.DevicePageParam;
import com.github.weichun97.entity.po.Device;
import com.github.weichun97.entity.vo.device.DevicePageVO;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    FgocPage<DevicePageVO> devicePage(FgocPage fgocPage, DevicePageParam param);
}
