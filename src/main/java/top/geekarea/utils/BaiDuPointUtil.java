package top.geekarea.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.geekarea.config.BaiduPointCongiguration;
import top.geekarea.enums.BaiduPointEnum;
import top.geekarea.exception.BaiduPointException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 百度定位工具类
 */
public class BaiDuPointUtil {

    private static double EARTH_RADIUS = 6371.393;
    private String result; //地理位置信息

    public BaiDuPointUtil() {}

    public BaiDuPointUtil(BaiduPointCongiguration baiduPointCongiguration) throws BaiduPointException {
        this.result = this.getLocationIP(baiduPointCongiguration);
    }

    /**
     * 通过ip地址获取用户地理位置
     * @param baiduPointCongiguration
     * @return result 地理位置信息
     * @throws BaiduPointException 用户ip为空则抛出异常
     */
    public String getLocationIP(BaiduPointCongiguration baiduPointCongiguration) throws BaiduPointException {
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        if ("".equals(baiduPointCongiguration.getIp())) {
            throw new BaiduPointException(BaiduPointEnum.IP_NULL);
        }
        try{
            url = new URL(baiduPointCongiguration.toString());
            in = new BufferedReader( new InputStreamReader(url.openStream(),"UTF-8") );
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        } finally{
            try{
                if(in!=null) {
                    in.close();
                }
            }catch(IOException ex) {
            }
        }
        return sb.toString();
    }

    /**
     * 获取纬度
     * @return lat
     */
    public double getLatitude() {
        double lat = -1;
        if (this.result != null) {
            JSONObject jsonObject = (JSONObject)JSON.parse(this.result);
            JSONObject j1 = (JSONObject)jsonObject.get("content");
            if (j1 != null) {
                JSONObject j2 = (JSONObject) j1.get("point");
                if (j2 != null) {
                    lat = j2.getDouble("y");
                }
            }
        }
        return lat;
    }

    /**
     * 获取经度
     * @return lon
     */
    public double getLongitude() {
        double lon = -1;
        if (this.result != null) {
            JSONObject jsonObject = (JSONObject)JSON.parse(this.result);
            JSONObject j1 = (JSONObject)jsonObject.get("content");
            if (j1 != null) {
                JSONObject j2 = (JSONObject) j1.get("point");
                if (j2 != null) {
                    lon = j2.getDouble("x");
                }
            }
        }
        return lon;
    }

    /**
     * 获取城市名
     * @return
     */
    public String getCityName() {
        JSONObject jsonObject = (JSONObject)JSON.parse(this.result);
        return null;
    }

    /**
     * 计算两经纬度之间的直线距离
     * @param latitude1
     * @param longitude1
     * @param latitude2
     * @param longitude2
     * @return s 单位米
     */
    public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2)
    {
        double radLat1 = latitude1 * Math.PI / 180.0;
        double radLat2 = latitude2 * Math.PI / 180.0;
        double a = radLat1 - radLat2;
        double b = longitude1 * Math.PI / 180.0 - longitude2 * Math.PI / 180.0;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }
}
