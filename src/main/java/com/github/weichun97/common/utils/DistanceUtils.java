package com.github.weichun97.common.utils;

public class DistanceUtils {

    /**
     * 地球半径,单位 km
     */
    private static final double EARTH_RADIUS = 6378.137;

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param coordinate1 坐标1
     * @param coordinate2 坐标2
     * @return 返回距离 单位米 向上取整
     */
    public static int getDistance(String coordinate1, String coordinate2) {

        String coordinate1s[] = coordinate1.split(",");
        String coordinate2s[] = coordinate2.split(",");

        // 经度
        double lng1 = Math.toRadians(Double.parseDouble(coordinate1s[0]));
        double lng2 = Math.toRadians(Double.parseDouble(coordinate2s[0]));


        // 纬度
        double lat1 = Math.toRadians(Double.parseDouble(coordinate1s[1]));
        double lat2 = Math.toRadians(Double.parseDouble(coordinate2s[1]));

        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 米
        s = s * EARTH_RADIUS * 100;
        return (int) Math.ceil(s);
    }

    public static void main(String[] args) {
        String coordinate2 = "116.413731,39.979324";
        String coordinate1 = "116.413731,39.979324";
        System.out.println(getDistance(coordinate1, coordinate2));
    }

}
