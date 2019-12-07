package com.learn.elastic.jparepository;

import com.learn.elastic.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryJpaRepository extends JpaRepository<Salary, Integer> {
}
