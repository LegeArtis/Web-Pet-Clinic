package models;

import PetClinic.Pet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JS
 * @since 06.09.2018
 */

public class UserTest {
    User user = new User(1,"testLogin","testEmail", new Pet("testName","testType"), "testPhone","testSex","testCity","true");



    @Test
    public void createTest() {
        assertEquals(user.getName(),"testLogin");
        assertEquals(user.getEmail(),"testEmail");
        assertEquals(user.getId(),1);
        assertEquals(user.getPhone(),"testPhone");
        assertEquals(user.getPet().getName(),"testName");
        assertEquals(user.getPet().getType(),"testType");
        assertEquals(user.getCity(),"testCity");
        assertEquals(user.getSex(),"testSex");
        assertEquals(user.getAgree(),"true");
    }
}