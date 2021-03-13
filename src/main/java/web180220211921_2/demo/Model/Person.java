package web180220211921_2.demo.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Person {
    @Id
    private int id;

    private String first_name;
    private String last_name;

    public Person(){}

    public Person(int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public void setId(int id) {
        this.id = id;
    }
    @javax.persistence.Id
    public int getId() {
        return id;
    }
}
