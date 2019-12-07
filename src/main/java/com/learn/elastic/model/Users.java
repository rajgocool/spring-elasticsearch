package com.learn.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;

@Document(indexName = "userr", type = "users")
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String teamName;

//    @Field(type = FieldType.Nested, includeInParent = true)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    @Field(type = FieldType.Object)
    private Salary salary;

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", teamName='" + teamName + '\'' +
                ", salary=" + salary +
                '}';
    }
    //private Long salary;

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Salary getSalary() {
        return salary;
    }


    public Users(String name, String teamName, Salary salary) {
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }

    public Users() {
        super();
    }
}
