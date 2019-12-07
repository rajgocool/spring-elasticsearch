package com.learn.elastic.queryBuilder;

import com.learn.elastic.model.Users;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public List<Users> getAll(String text) {

        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)
                                .field("name")
                                .field("teamName")
                                .field("salary.salary")
                ).should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true)
                        .field("name")
                        .field("teamName"))
                .should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true)
                        .field("name")
                        .field("teamName")
                        .field("salary.salary")
                );

//                .should(QueryBuilders.nestedQuery("salary", QueryBuilders.boolQuery()
//                        .should(
//                            QueryBuilders.queryStringQuery(text)
//                                .lenient(true)
//                                .field("salary"))


        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Users> userses = elasticsearchTemplate.queryForList(build, Users.class);

        return userses;
    }
}
