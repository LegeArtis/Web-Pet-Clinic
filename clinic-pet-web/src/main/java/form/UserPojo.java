package form;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "login",
        "phone",
        "petName",
        "city",
        "sex",
        "agree",
        "petType",
        "email"
})
public class UserPojo {

    @JsonProperty("id")
    private int id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("petName")
    private String petName;
    @JsonProperty("city")
    private String city;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("agree")
    private String agree;
    @JsonProperty("petType")
    private String petType;
    @JsonProperty("email")
    private String email;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("petName")
    public String getPetName() {
        return petName;
    }

    @JsonProperty("petName")
    public void setPetName(String petName) {
        this.petName = petName;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonProperty("agree")
    public String getAgree() {
        return agree;
    }

    @JsonProperty("agree")
    public void setAgree(String agree) {
        this.agree = agree;
    }

    @JsonProperty("petType")
    public String getPetType() {
        return petType;
    }

    @JsonProperty("petType")
    public void setPetType(String petType) {
        this.petType = petType;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

}