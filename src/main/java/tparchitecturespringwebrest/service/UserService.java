package tparchitecturespringwebrest.service;


import tparchitecturespringwebrest.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<User>();
        User user1 = new User(1, "zakaria", "zakaria@gmail.com");
        User user2 = new User(2, "nizar", "nizar@gmail.com");
        User user3 = new User(3, "mouad", "mouad@gmail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
    public List<User> getUsers() {
        return users;
    }

    public User getUser(int id) {
        return users.stream().filter(user1 -> user1.getId() == id).findFirst().get();
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public String deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(getUser(id));
                return "User deleted";
            }
        }
        return "user not found";
    }

    public User updateUser(int id, User user) {
        User u = getUser(id);
        BeanUtils.copyProperties(user, u);
        return u;
    }
}