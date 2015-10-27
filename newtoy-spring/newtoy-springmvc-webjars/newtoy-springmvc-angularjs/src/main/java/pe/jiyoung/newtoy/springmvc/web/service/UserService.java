package pe.jiyoung.newtoy.springmvc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jiyoung.newtoy.spring.mybatis.dao.UserDao;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

}
