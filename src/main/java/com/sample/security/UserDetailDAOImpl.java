package com.sample.security;

import com.oauth.dao.UserDetailDAO;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailDAOImpl implements UserDetailDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserDetailDAOImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public com.oauth.data.User fetchUser(String username) {
        User user=userDao.findByPhone(username);
        com.oauth.data.User user1=new com.oauth.data.User();
        user1.setUserMail(user.getPhone());
        return user1;
    }
}
