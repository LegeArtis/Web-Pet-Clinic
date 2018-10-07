package form;

import PetClinic.Pet;
import models.User;

/**
 * @author JS
 * @since 06.09.2018
 */

public class UserForm {
    private String login;
    private String phone;
    private String petName;
    private String city;
    private String sex;
    private String agree;
    private String petType;
    private String email;


    public UserForm(String login, String phone, String petName, String city, String sex, String agree, String petType, String email) {
        this.login = login;
        this.phone = phone;
        this.petName = petName;
        this.city = city(city);
        this.sex = sex;
        this.agree = agreeConvert(agree);
        this.petType = petType;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public String getPetType() {
        return petType;
    }

    public String getPhone() {
        return phone;
    }

    public String getPetName() {
        return petName;
    }

    public String getCity() {
        return city;
    }

    public String getSex() {
        return sex;
    }

    public String getLogin() {
        return login;
    }

    /**
     * Create User class from UserForm
     * @return User class
     */
    public User toUser(){
        User user = new User();
        Pet pet = new Pet(this.petName, this.petType);
        user.setAgree(this.agree);
        user.setCity(this.city);
        user.setEmail(this.email);
        user.setName(this.login);
        user.setPet(pet);
        user.setPhone(this.phone);
        user.setSex(this.sex);
        return user;
    }
}
