package models;

import PetClinic.Pet;

public class UserExtended extends User {
    private final String sex;
    private final String city;
    private final boolean agree;

    public UserExtended(int id, String login, String email, Pet pet, String phone, String sex, String city, boolean agree) {
        super(id, login, email, pet, phone);
        this.sex = sex;
        this.city = city;
        this.agree = agree;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public boolean isAgree() {
        return agree;
    }
}
