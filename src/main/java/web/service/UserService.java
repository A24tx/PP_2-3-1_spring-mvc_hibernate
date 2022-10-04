package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

public abstract class UserService {

    public abstract void saveUser(User u);

    public abstract List<User> getUsers();

    public abstract User getUserById(long id);

    public abstract void updateUser(User user);

    public abstract void removeUser(long id);


}
