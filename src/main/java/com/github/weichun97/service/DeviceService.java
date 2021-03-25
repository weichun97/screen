package com.github.weichun97.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.common.page.FgocPage;
import com.github.weichun97.common.page.PageParam;
import com.github.weichun97.entity.param.device.DevicePageParam;
import com.github.weichun97.entity.param.device.DeviceSaveUpdateParam;
import com.github.weichun97.entity.po.Device;
import com.github.weichun97.entity.vo.device.DeviceVO;
import com.github.weichun97.entity.vo.device.DevicePageVO;

/**
 * @author chun
 * @date 2020/9/4
 * @description
 */
public interface DeviceService extends IService<Device> {

    /**
     * 保存数据
     *
     * @param param
     */
    void save(DeviceSaveUpdateParam param);

    /**
     * 修改数据
     *
     * @param param
     * @param id
     */
    void update(DeviceSaveUpdateParam param, Long id);

    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    FgocPage<DevicePageVO> devicePage(PageParam page, DevicePageParam param);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    DeviceVO device(Long id);


    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    void deleteById(Long id);
}
