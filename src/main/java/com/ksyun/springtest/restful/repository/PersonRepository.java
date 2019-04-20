package com.ksyun.springtest.restful.repository;

import com.ksyun.springtest.restful.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}