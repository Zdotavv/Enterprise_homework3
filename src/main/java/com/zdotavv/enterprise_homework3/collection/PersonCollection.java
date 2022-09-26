package com.zdotavv.enterprise_homework3.collection;

import com.zdotavv.enterprise_homework3.model.Person;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class PersonCollection {

    private final Map<Integer, Person> persons = new HashMap<>();
}
