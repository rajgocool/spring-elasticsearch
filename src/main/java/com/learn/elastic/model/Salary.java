package com.learn.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(indexName = "userr", type = "salary")
@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Long salary;

    public Salary() {
        super();
    }

    public Salary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
