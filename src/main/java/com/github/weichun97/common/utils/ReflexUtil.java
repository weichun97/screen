package com.github.weichun97.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chun
 * @date 2020/11/26
 * @description 反射工具类
 */
public class ReflexUtil {

    public static Object getGetMethod(Object ob, String name) {
        Method[] m = ob.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {
            if (("get" + name).toLowerCase().equals(m[i].getName().toLowerCase())) {
                try {
                    return m[i].invoke(ob);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
}
