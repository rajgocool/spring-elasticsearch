package com.learn.elastic.resource;

import com.learn.elastic.model.Salary;
import com.learn.elastic.model.Users;
import com.learn.elastic.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudRespository {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping()
    public Users createUser(@RequestBody  Users users) {
        Salary salary = new Salary(users.getSalary().getSalary());
        Users user = new Users(users.getName(),users.getTeamName(),salary);
        return usersRepository.save(user);
    }

    @GetMapping("{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersRepository.findOne(id);
    }

    @GetMapping()
    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        usersRepository.findAll().forEach(usersList::add);
        return usersList;
    }

    @PutMapping()
    public Users updateUsers(@RequestBody  Users users) {
        return usersRepository.save(users);
    }

    @DeleteMapping("{id}")
    public void updateUsers(@PathVariable  Long id) {
         usersRepository.delete(id);
    }
}
