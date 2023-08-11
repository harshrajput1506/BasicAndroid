package in.hypernation.learnjava;

public class Animal {
    String name;
    int type;

    public Animal(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public Animal(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
