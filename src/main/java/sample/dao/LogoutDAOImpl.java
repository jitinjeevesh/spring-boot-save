package sample.dao;

import com.oauth.dao.LogoutDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogoutDAOImpl implements LogoutDAO {

    private final static Logger logger = LoggerFactory.getLogger(LogoutDAOImpl.class);

    @Override
    @Transactional
    public void session(String token) {
    }

    @Override
    @Transactional
    public void user(String username) {
    }
}
