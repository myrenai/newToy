package pe.jiyoung.newtoy.spring.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringMvcTestBase {

    @Test
    public void test(){}

}
