package cn.chinatax.microweatherbasic.service;

import cn.chinatax.microweatherbasic.Vo.City;

import java.util.List;

/**
 * @program: micro-weather-basic
 * @description:
 * @author: Mr. Tigger
 * @create 2019-08-31 09:40
 **/
public interface CityDataService {
    /**
     * 获取城市列表.
     *
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
