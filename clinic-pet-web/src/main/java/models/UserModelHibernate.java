package models;

import javax.persistence.*;

@Entity
    @Table(name = "client")
    public class UserModelHibernate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "uid")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "city")
    private String city;
    @Column(name = "sex")
    private String sex;
    @Column(name = "email")
    private String email;
    @Column(name = "agree")
    private String agree;

    public UserModelHibernate() {
    }

    public UserModelHibernate(int id, String name, String phone, String city, String sex, String email, String agree) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.sex = sex;
        this.email = email;
        this.agree = agree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }
}
