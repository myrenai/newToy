package pe.jiyoung.newtoy.spring.mvc.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.jiyoung.newtoy.spring.mvc.domain.User;
import pe.jiyoung.newtoy.spring.mybatis.dao.UserDao;
import pe.jiyoung.newtoy.spring.util.ConvertUtil;

@Component
public class UserManager {

    @Autowired
    private UserDao userDao;

    public User findById(final String userId){

        final Map<String, Object> map = this.userDao.findById(userId);
        return ConvertUtil.mapToUser(map);
    }

    public User create(final User user){
        this.userDao.create(ConvertUtil.userToMap(user));
        return this.findById(user.getUserId());
    }

    public void update(final User updatedUser) {
        this.userDao.update(ConvertUtil.userToMap(updatedUser));

    }
}
