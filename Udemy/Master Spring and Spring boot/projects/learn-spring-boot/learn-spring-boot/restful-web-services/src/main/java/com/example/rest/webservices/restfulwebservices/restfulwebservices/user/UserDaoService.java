package com.example.rest.webservices.restfulwebservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User>users= new ArrayList<>();
    static int cnt=1;
    static {
        users.add(new User(cnt++, "name1", LocalDate.now().minusYears(20)));
        users.add(new User(cnt++, "name2", LocalDate.now().minusYears(30)));
        users.add(new User(cnt++, "name3", LocalDate.now().minusYears(40)));
        users.add(new User(cnt++, "name4", LocalDate.now().minusYears(25)));
    }
    public List<User> findAll(){
        return users;
    }
    public User findOne(int id)
    {
        Predicate<? super User> predicate= user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public User save (User user)
    {
        user.setId(cnt++);
        users.add(user);
        return user;
    }
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
