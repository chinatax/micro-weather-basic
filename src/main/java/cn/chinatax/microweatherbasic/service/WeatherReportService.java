package cn.chinatax.microweatherbasic.service;

import cn.chinatax.microweatherbasic.Vo.Weather;

/**
 * @program: micro-weather-basic
 * @description:
 * @author: Mr. Tigger
 * @create 2019-08-31 10:27
 **/
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);

}
