package cn.chinatax.microweatherbasic.service;

import cn.chinatax.microweatherbasic.Vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * @Author Tigger
 * @ClassName WeaterDataService
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/

public interface WeatherDataService {

   
    /** 
    * @Description: 根据城市ID查询天气数据 
    * @Param: [cityId] 
    * @return: cn.chinatax.microweatherbasic.Vo.WeatherResponse 
    * @Author: Mr.Tigger 
    * @Date: 2019/8/29 
    */ 
    WeatherResponse   getDataByCityId(String cityId);

    
    /** 
    * @Description: 根据城市名称查询天气数据 
    * @Param: [cityName] 
    * @return: cn.chinatax.microweatherbasic.Vo.WeatherResponse 
    * @Author: Mr.Tigger 
    * @Date: 2019/8/29 
    */ 
    WeatherResponse   getDataByCityName(String cityName);

}
