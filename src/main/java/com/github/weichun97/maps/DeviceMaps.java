package com.github.weichun97.maps;

import com.github.weichun97.entity.param.device.DeviceSaveUpdateParam;
import com.github.weichun97.entity.po.Device;
import com.github.weichun97.entity.vo.device.DevicePageVO;
import com.github.weichun97.entity.vo.device.DeviceVO;

import org.mapstruct.Mapper;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface DeviceMaps {

    /**
     * saveUpdateParam转换po
     *
     * @param param the param
     * @return device
     */
    Device saveUpdateParamToPo(DeviceSaveUpdateParam param);

    /**
     * Po to vo device vo.
     *
     * @param device the device
     * @return the device vo
     */
    DeviceVO poToVo(Device device);

    /**
     * Po to page vo device page vo.
     *
     * @param device the device
     * @return the device page vo
     */
    DevicePageVO poToPageVo(Device device);

    /**
     * Po to page vo list.
     *
     * @param devices the devices
     * @return the list
     */
    List<DevicePageVO> poToPageVo(List<Device> devices);
}
