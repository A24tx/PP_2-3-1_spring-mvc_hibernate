package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public void addUser(User u);

    public User getUser(long id);

    public void removeUser(long id);

    public List<User> getAllUsers();

    public void updateUser(User u);
}
