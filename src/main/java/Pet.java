public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet(Animal animal){
        this.name = animal.name;
    }

    public Pet() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
