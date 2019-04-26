package com.ksyun.springtest.restful;

import com.ksyun.springtest.restful.entity.Person;
import com.ksyun.springtest.restful.repository.PersonRepository;

import org.junit.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class PersonRepsTest extends BaseJunit4Test {
    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test() {
        System.out.println("begin spring junit4");
        Person p = new Person("name", 21, "address");
        personRepository.save(p);

        List<Person> persons = personRepository.findAll();
        for (Person per : persons) {
            System.out.println(per.getName());
        }
    }
}