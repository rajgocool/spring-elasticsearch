package com.learn.elastic.jparepository;

import com.learn.elastic.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users, Long> {
}
