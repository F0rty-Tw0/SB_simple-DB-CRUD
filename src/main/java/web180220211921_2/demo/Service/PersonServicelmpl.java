package web180220211921_2.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web180220211921_2.demo.Model.Person;
import web180220211921_2.demo.Repository.IPersonRepo;

import java.util.List;

@Service
public class PersonServicelmpl implements IPersonService{
    @Autowired
    IPersonRepo personRepo;

    @Override
    public List<Person> fetchAll() {
        return personRepo.fetchAll();
    }

    @Override
    public Person findPersonById(int id) {

        return personRepo.findPersonById(id);
    }

    @Override
    public Person addPerson(Person p) {
        return personRepo.addPerson(p);
    }

    @Override
    public Boolean deleteUser(int id) {
        return personRepo.deleteUser(id);
    }

    @Override
    public Person updatePerson(int id, Person p) {
        return personRepo.updatePerson(id, p);
    }
}
