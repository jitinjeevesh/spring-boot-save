package com.sample.security;

import com.oauth.dao.UserDetailDAO;
import com.oauth.data.UserRole;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.Role;
import com.sample.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailDAOImpl implements UserDetailDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserDetailDAOImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public com.oauth.data.User fetchUser(String username) {
        User user = userDao.findByMobileNumber(username);
        List<Role> roles = user.getRoles();
        UserRole userRole = new UserRole();
        userRole.setRole(roles.stream().findFirst().get().getUserRole());
        com.oauth.data.User user1 = new com.oauth.data.User();
        user1.setId(user.getId().toString());
        user1.setUserMail(user.getPhone());
        user1.setUserRole(userRole);
        return user1;
    }
}
