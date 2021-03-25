package com.github.weichun97.common.utils;

import com.github.weichun97.common.api.Response;
import com.github.weichun97.common.api.ResultCode;
import com.github.weichun97.common.exception.ApiException;

/**
 * @author chun
 * @date 2020/9/15
 * @description 远程接口调用数据解析
 */
public class ApiUtil {

    private static long OK = 200;


    /**
     * 传递一个Response 对象 解析里面的code和数据
     *
     * @param response
     * @param <T>
     * @return
     */
    public static <T> T getApiData(Response<T> response) {

        if (response.getCode() == OK) {

            return response.getData();
        }
        throw new ApiException(ResultCode.REMOTE_CALL_FAILED);

    }
}
