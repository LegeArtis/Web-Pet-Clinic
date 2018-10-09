package models;

import PetClinic.Pet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pet")
public class PetModelHibernate implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "uid")
    private int id;

    @Column(name = "nick")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "client_id")
    private int clientId;

    public PetModelHibernate(String name, String type, int id, int clientId) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.clientId = clientId;
    }

    public PetModelHibernate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Create Pet class from PetModelHibernate
     * @return Per class
     */
    public Pet toPet(){
        return new Pet(this.name,this.getType());
    }
}
