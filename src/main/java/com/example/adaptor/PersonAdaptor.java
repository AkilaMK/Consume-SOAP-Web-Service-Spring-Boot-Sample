package com.example.adaptor;

import com.example.model.Person;

/**
 * Created by akila on 12/12/16.
 */
public class PersonAdaptor {
    public static Person getPersonModel(com.example.gen.Person p) {
        Person person = new Person();
        person.setName(p.getName());
        person.setAge(p.getAge());
        person.setId(p.getId());

        return person;
    }

    public static com.example.gen.Person getGeneratedPerson(Person p) {
        com.example.gen.Person person = new com.example.gen.Person();
        person.setName(p.getName());
        person.setAge(p.getAge());
        person.setId(p.getId());

        return person;
    }
}
