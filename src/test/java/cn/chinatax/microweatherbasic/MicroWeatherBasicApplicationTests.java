package cn.chinatax.microweatherbasic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Tigger
 * @ClassName RedisTest
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackageClasses = MicroWeatherBasicApplication.class)
public class MicroWeatherBasicApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @Test
    public void test() throws Exception{

        // 保存字符串
        stringRedisTemplate.opsForValue().set("tigge", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("tigger"));

    }
}
