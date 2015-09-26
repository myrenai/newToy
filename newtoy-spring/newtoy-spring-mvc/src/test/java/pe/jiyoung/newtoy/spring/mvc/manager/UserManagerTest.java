package pe.jiyoung.newtoy.spring.mvc.manager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import pe.jiyoung.newtoy.spring.mvc.SpringMvcTestBase;
import pe.jiyoung.newtoy.spring.mvc.domain.User;

public class UserManagerTest extends SpringMvcTestBase{

    @Autowired
    UserManager userManager;

    @Test
    public void findById() {
        final User user = this.userManager.findById("myrenai");
        Assert.notNull(user);
    }

}
