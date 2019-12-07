package com.learn.elastic.load;

import com.learn.elastic.jparepository.UserJpaRepository;
import com.learn.elastic.model.Salary;
import com.learn.elastic.model.Users;
import com.learn.elastic.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);

        System.out.println("Loading Data");
        List<Users> data = getData();
        userJpaRepository.save(data); //saves to H2 DB

        List<Users> usersList = userJpaRepository.findAll(); //Get from H2 DB
        usersRepository.save(usersList); //loads into Elastic
        System.out.println("Loading Completed");

    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        userses.add(new Users("Ajay", "Accounting", new Salary(12000L)));
        userses.add(new Users("Techie", "Accounting", new Salary(12000L)));
        userses.add(new Users("Jaga", "Finance", new Salary(22000L)));
        userses.add(new Users("Shiva", "Tech", new Salary(21000L)));
        userses.add(new Users("Karthick", "Tech", new Salary(21000L)));
        userses.add(new Users("Bhuvanesh", "Accounting", new Salary(21000L)));
        userses.add(new Users("Kumaran", "Tech", new Salary(22000L)));
        userses.add(new Users("Thiru","Accounting", new Salary(12000L)));
        return userses;
    }
}
