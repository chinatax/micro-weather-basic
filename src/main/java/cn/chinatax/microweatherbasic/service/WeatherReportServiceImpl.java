package cn.chinatax.microweatherbasic.service;

import cn.chinatax.microweatherbasic.Vo.Weather;
import cn.chinatax.microweatherbasic.Vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: micro-weather-basic
 * @description:
 * @author: Mr. Tigger
 * @create 2019-08-31 10:28
 **/
@Service
public class WeatherReportServiceImpl implements  WeatherReportService {

        @Autowired
        private WeatherDataService weatherDataServiceImpl;

        @Override
        public Weather getDataByCityId(String cityId) {
            WeatherResponse result = weatherDataServiceImpl.getDataByCityId(cityId);
            return result.getData();
        }
}
