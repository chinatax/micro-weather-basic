package cn.chinatax.microweatherbasic.service;

import cn.chinatax.microweatherbasic.Vo.City;
import cn.chinatax.microweatherbasic.Vo.CityList;
import cn.chinatax.microweatherbasic.util.XmlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @program: micro-weather-basic
 * @description:
 * @author: Mr. Tigger
 * @create 2019-08-31 09:41
 **/
@Service
public class CityDataServiceImpl implements CityDataService {

    private  final static Logger logger= LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final String   CITY_NAME = "citylist.xml";
    private Object CityList;

    @Override
    public List<City> listCity() throws Exception {
        Resource resource =  new ClassPathResource(CITY_NAME);
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer   stringBuffer =  new StringBuffer();

        logger.info("读取citylist.xml文件-->"+resource.getFile().getPath());
        String line = "";
        while(null != (line = bufferReader.readLine())){
            stringBuffer.append(line);

        }
        bufferReader.close();

        //logger.info(stringBuffer.toString());
        CityList citylist = (CityList) XmlBuilder.xmlStrToObject(CityList.class,stringBuffer.toString());

        return citylist.getCityList();
    }
}
