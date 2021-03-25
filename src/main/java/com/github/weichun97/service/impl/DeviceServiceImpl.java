package com.github.weichun97.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.common.api.SqlCode;
import com.github.weichun97.common.exception.ApiException;
import com.github.weichun97.common.page.FgocPage;
import com.github.weichun97.common.page.PageParam;
import com.github.weichun97.entity.param.device.DevicePageParam;
import com.github.weichun97.entity.param.device.DeviceSaveUpdateParam;
import com.github.weichun97.entity.po.Device;
import com.github.weichun97.entity.vo.device.DeviceVO;
import com.github.weichun97.entity.vo.device.DevicePageVO;
import com.github.weichun97.mapper.DeviceMapper;
import com.github.weichun97.maps.DeviceMaps;
import com.github.weichun97.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author chun
 * @date 2020/9/4
 * @description
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    private DeviceMaps maps;

    @Override
    public void save(DeviceSaveUpdateParam param) {
        Device device = maps.saveUpdateParamToPo(param);
        device.setCreateTime(new Date());
        int i = baseMapper.insert(device);
        if (i < 1) {
            throw new ApiException(SqlCode.INSERT_ERROR);
        }
    }

    @Override
    public void update(DeviceSaveUpdateParam param, Long id) {
        Device device = maps.saveUpdateParamToPo(param);
        device.setId(id);
        baseMapper.updateById(device);
    }

    @Override
    public FgocPage<DevicePageVO> devicePage(PageParam page, DevicePageParam param) {
        return baseMapper.devicePage(FgocPage.getPage(page), param);
    }

    @Nullable
    @Override
    public DeviceVO device(Long id) {
        Device device = this.getById(id);
        if (device != null) {
            return maps.poToVo(device);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        this.removeById(id);
    }
}
