package sample.dao;

import com.oauth.dao.UserDetailDAO;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailDAOImpl implements UserDetailDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserDetailDAOImpl.class);

    @Override
    @Transactional
    public com.oauth.data.User fetchUser(String username) {
        return null;
    }
}
