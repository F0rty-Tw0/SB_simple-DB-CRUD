package web180220211921_2.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import web180220211921_2.demo.Model.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Repository
public class PersonRepoImpl implements IPersonRepo{
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Person> fetchAll() {
        String sql="SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql,rowMapper);
    }

    @Override
    public Person findPersonById(int id) {
        String sql="SELECT * FROM person WHERE id=?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person p=template.queryForObject(sql,rowMapper,id);
        return p;
    }

    @Override
    public Person addPerson(Person p) {
        String sql="INSERT INTO person(first_name,last_name) VALUES(?,?)";
        template.update(sql,p.getFirst_name(),p.getLast_name());
        return null;
    }

    @Override
    public Boolean deleteUser(int id) {
        String sql="delete from person where id=?";
        return template.update(sql,id)>=0;

    }

    @Override
    public Person updatePerson(int id, Person p) {
        return null;
    }
}
