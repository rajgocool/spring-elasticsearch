package com.learn.elastic.resource;

import com.learn.elastic.model.Users;
import com.learn.elastic.queryBuilder.SearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/manual/search")
public class ManualSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @GetMapping(value = "/{text}")
    public List<Users> getAll(@PathVariable final String text) {
        List<Users> all = searchQueryBuilder.getAll(text);
        System.out.println(all);
        return all;
    }
}
