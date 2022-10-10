package web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usertable_pp231")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "country")
    private String country;

    public User(String name, int age, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public User(long id) {
        this.id = id;
    }

    public User() {
        //
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }
}
