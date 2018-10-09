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

    public UserForm(){}


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

    @Override
    public String toString() {
        return "ClassPojo [sex = "+sex+", phone = "+phone+", email = "+email+", petType = "+petType+", login = "+login+", petName = "+petName+", agree = "+agree+", city = "+city+"]";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
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

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
