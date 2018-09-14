package models;

import PetClinic.Pet;

/**
 * @author JS
 * @since 31.08.18
 */

public class User {
    private final int id;
    private final String login;
    private  final  String email;
    private final Pet pet;
    private final  String phone;


    public User(int id, String login, String email, Pet pet, String phone) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.pet = pet;
        this.phone = phone;

    }


    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
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
}
