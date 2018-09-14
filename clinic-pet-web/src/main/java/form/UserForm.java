package form;

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
    private boolean agree;
    private String petType;
    private String email;


    public UserForm(String login, String phone, String petName, String city, String sex, String agree, String petType, String email) {
        this.login = login;
        this.phone = phone;
        this.petName = petName;
        this.city = city(city);
        this.sex = sex(sex);
        this.agree = agree(agree);
        this.petType = petType;
        this.email = email;
    }

    private boolean agree(String s){
        return s.compareTo("on") == 0;
    }

    private String sex(String sex){
        if (sex.compareTo("Муж")==0){
            return "Муж.";
        }else {
            return "Жен.";
        }
    }

    private String city(String s){
        String c;
        int a = Integer.getInteger(s);
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

    public boolean isAgree() {
        return agree;
    }

    public String getLogin() {
        return login;
    }
}
