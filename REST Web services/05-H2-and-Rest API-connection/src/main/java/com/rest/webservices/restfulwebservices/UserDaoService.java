package com.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Anuj", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Tanmay", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount, "Pragati", LocalDate.now().minusYears(27)));
    }



    public static List<User> findAll() {
        return users;
    }

    public User findOneUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("id : ", id);
    }

    public User createuser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteByID(int id) {
        int i = -1;
        for (User user : users) {
            i += 1;
            if (user.getId() == id) {
                users.remove(i);
                break;
            }
        }
    }
}
