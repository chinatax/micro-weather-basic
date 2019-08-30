package cn.chinatax.microweatherbasic.controller;

import cn.chinatax.microweatherbasic.Vo.WeatherResponse;
import cn.chinatax.microweatherbasic.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tigger
 * @ClassName WeatherController
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){

        return  weatherDataService.getDataByCityId(cityId);
    }
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){

        return  weatherDataService.getDataByCityName(cityName);
    }
}
