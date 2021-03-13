package web180220211921_2.demo.Repository;

import web180220211921_2.demo.Model.Person;

import java.util.List;

public interface IPersonRepo {
    List<Person> fetchAll();

    Person findPersonById(int id);

    Person addPerson(Person p);

    Boolean deleteUser(int id);

    Person updatePerson(int id, Person p);
}
