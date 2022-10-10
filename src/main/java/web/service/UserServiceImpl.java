package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoHibernateImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao implementation;

    public UserServiceImpl(UserDaoHibernateImpl implementation) {
        this.implementation = implementation;
    }

    @Override
    public void saveUser(User u) {
        implementation.addUser(u);
    }

    @Override
    public void removeUser(long id) {
        implementation.removeUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return implementation.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return implementation.getUser(id);
    }

    public void updateUser(User u) {
        implementation.updateUser(u);
    }

}
