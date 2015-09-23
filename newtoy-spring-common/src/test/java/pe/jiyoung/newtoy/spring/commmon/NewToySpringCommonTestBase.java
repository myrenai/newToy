package pe.jiyoung.newtoy.spring.commmon;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.jiyoung.newtoy.spring.common.util.ToyPropertyResolver;

@ContextConfiguration(locations = { "classpath:spring/test-spring-common-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class NewToySpringCommonTestBase {

    @Test
    public void propertyResolverTest() {
        final String actual1 = "COMMON1";
        final String actual2 = "COMMON2";
        Assert.assertThat(actual1, is(ToyPropertyResolver.getProperty("common1")));
        Assert.assertThat(actual2, is(ToyPropertyResolver.getProperty("common2")));
    }
}
