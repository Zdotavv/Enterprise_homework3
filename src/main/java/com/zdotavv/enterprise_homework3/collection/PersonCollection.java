package com.zdotavv.enterprise_homework3.collection;

import com.zdotavv.enterprise_homework3.model.Person;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PersonCollection {

    public static Set<Person> persons=new HashSet<>();
}
