package com.github.weichun97.common.utils;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author chun
 * @date 2020/8/13
 * @description iputil
 */
public class IPUtil {


    public static String getLocalIp() {

        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "0.0.0.0";
        }
    }
}
