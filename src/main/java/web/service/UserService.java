package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User u);

    List<User> getUsers();

    User getUserById(long id);

    void updateUser(User user);

    void removeUser(long id);


}
