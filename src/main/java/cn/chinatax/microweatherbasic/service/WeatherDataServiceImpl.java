package cn.chinatax.microweatherbasic.service;

import cn.chinatax.microweatherbasic.Vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Tigger
 * @ClassName WeatherDataServiceImpl
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private  final static Logger logger= LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private  final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private  final long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {

        String  url =  WEATHER_URI +"citykey=" + cityId;

        return this.doGetWeather(url);


    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URI + "city=" + cityName;

        return this.doGetWeather(url);
    }

    private WeatherResponse doGetWeather(String url){


        String key = url;
        String strBody = null;

        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();

        if (!this.stringRedisTemplate.hasKey(key)){
            logger.info("Redis hasn't  data");
            ResponseEntity<String> restString = restTemplate.getForEntity(url,String.class);

            if (restString.getStatusCodeValue() == 200){
                strBody = restString.getBody();
            }
            ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
        } else{
            strBody = ops.get(key);
            logger.info("Redis has data");
        }

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse rest = null;

        try {
            rest = mapper.readValue(strBody,WeatherResponse.class);

        } catch (IOException e ){

           logger.error("error!",e);
        }
        return rest;

    }

}