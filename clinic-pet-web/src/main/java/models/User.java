package models;

import PetClinic.Pet;
import form.UserPojo;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JS
 * @since 31.08.18
 */


public class User {
    private int id;
    private String name;
    private String email;
    private  Pet pet;
    private  String phone;
    private  String sex;
    private  String city;
    private  String agree;

    public User(){}

    public User(UserModelHibernate userModelHibernate, Pet pet){
        this.id = userModelHibernate.getId();
        this.name = userModelHibernate.getName();
        this.email = userModelHibernate.getEmail();
        this.pet = pet;
        this.phone = userModelHibernate.getPhone();
        this.sex = userModelHibernate.getSex();
        this.city = userModelHibernate.getCity();
        this.agree = userModelHibernate.getAgree();
    }

    public User(int id, String name, String email, Pet pet, String phone, String sex, String city, String agree) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pet = pet;
        this.phone = phone;
        this.sex = sex;
        this.city = city;
        this.agree = agree;
    }

    public User(UserPojo pojo){
        Pet pet = new Pet(pojo.getPetName(),pojo.getPetType());
        this.id = pojo.getId();
        this.name = pojo.getLogin();
        this.email = pojo.getEmail();
        this.pet = pet;
        this.phone = pojo.getPhone();
        this.sex = pojo.getSex();
        this.city = city(pojo.getCity());
        this.agree = agreeConvert(pojo.getAgree());
    }

    /**
     * Convert radio(on/off) to true/false by String
     * @param text radio
     * @return String line
     */
    private String agreeConvert(String text){
        if (text.compareTo("on")==0)
            return "true";
        else
            return "false";
    }

    /**
     * Convert choose param to city name
     * @param s choose param
     * @return city name
     */
    private String city(String s){
        String c;
        int a = Integer.parseInt(s);
        if (a == 1){
            c = "Киев";
        }
        else {
            c = "Ирпень";
        }
        return  c;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Pet getPet() {
        return pet;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getAgree() {
        return agree;
    }

    /**
     * Create UserPojo class from User class
     * @return UserPojo class
     */
    public UserPojo toUserPojo(){
        UserPojo pojo = new UserPojo();
        pojo.setAgree(this.agree);
        pojo.setCity(this.city);
        pojo.setEmail(this.email);
        pojo.setLogin(this.name);
        pojo.setPetName(this.pet.getName());
        pojo.setPetType(this.pet.getType());
        pojo.setPhone(this.phone);
        pojo.setSex(this.sex);
        pojo.setId(this.id);
        return pojo;
    }

    /**
     * Create UserModelHibernate class from User
     * @return UserModelHibernate class
     */
    public UserModelHibernate getUserModelHibernate(){
        UserModelHibernate userModelHibernate = new UserModelHibernate();
        userModelHibernate.setId(this.id);
        userModelHibernate.setAgree(this.agree);
        userModelHibernate.setCity(this.city);
        userModelHibernate.setEmail(this.email);
        userModelHibernate.setName(this.name);
        userModelHibernate.setPhone(this.phone);
        userModelHibernate.setSex(this.sex);
        return userModelHibernate;
    }

    /**
     * Create PetModelHibernate with user ID from User
     * @param userId user ID
     * @return PetModelHibernate class
     */
    public PetModelHibernate getPetModelHibernate(int userId){
        PetModelHibernate pet = new PetModelHibernate();
        pet.setClientId(userId);
        pet.setName(this.pet.getName());
        pet.setType(this.pet.getType());
        return pet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pet=" + pet.toString() +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", agree='" + agree + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }
}
