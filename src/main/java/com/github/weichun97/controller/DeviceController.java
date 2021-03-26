package com.github.weichun97.controller;

import com.github.weichun97.common.api.Response;
import com.github.weichun97.common.page.FgocPage;
import com.github.weichun97.common.page.PageParam;
import com.github.weichun97.entity.param.device.DevicePageParam;
import com.github.weichun97.entity.param.device.DeviceSaveUpdateParam;
import com.github.weichun97.entity.vo.device.DevicePageVO;
import com.github.weichun97.entity.vo.device.DeviceVO;
import com.github.weichun97.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author chun
 * @date 2020/9/4
 * @description
 */
@RequestMapping("device")
@RestController
@Api(value = "DeviceController", tags = "设备")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @GetMapping("{id}")
    @ApiOperation(value = "根据id获取")
    public Response<DeviceVO> device(@PathVariable Long id) {
        return Response.success(service.device(id));
    }

    @GetMapping("page")
    @ApiOperation(value = "分页查询")
    public Response<FgocPage<DevicePageVO>> devicePage(PageParam page, @Valid DevicePageParam param) {
        return Response.success(service.devicePage(page, param));
    }

    @PostMapping
    @ApiOperation(value = "新增")
    public Response save(@Valid @RequestBody DeviceSaveUpdateParam param) {
        service.save(param);
        return Response.success();
    }

    @PutMapping("{id}")
    @ApiOperation(value = "修改")
    public Response update(@Valid @RequestBody DeviceSaveUpdateParam param, @PathVariable Long id) {
        service.update(param, id);
        return Response.success();
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除")
    public Response deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return Response.success();

    }
}
