package ir.ac.kntu;
import java.util.ArrayList;

public class Costumer {
    private String name;
    private String id;
    private int shops;
    public Costumer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addAProduct(){
        shops++;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getShopsNumber() {
        return shops;
    }


    public static Costumer searchCostumerByID(ArrayList<Costumer> costumers, String id) {
        Costumer costumer = null;
        for (Costumer value : costumers) {
            if (value.getId().equals(id)) {
                costumer = value;
                break;
            }
        }
        return costumer;
    }

    public static String searchCostumerByName(ArrayList<Costumer> costumers, String name) {
        String costumer = "We don't have costumer named: " + name;
        for (Costumer value : costumers) {
            if (value.getName().equals(name)) {
                costumer = value.toString();
                break;
            }
        }
        return costumer;
    }

    public static String searchCostumerByIdInString(ArrayList<Costumer> costumers, String id) {
        String costumer = "We don't have costumer with ID of: " + id;
        for (Costumer value : costumers) {
            if (value.getId().equals(id)) {
                costumer = value.toString();
                break;
            }
        }
        return costumer;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", shop numbers=" + shops +
                '}';
    }
}
