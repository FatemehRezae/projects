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

    public int getShops() {
        return shops;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static Costumer searchCostumerByID(ArrayList<Costumer> costumers, String id) {
        Costumer costumer = null;
        for (int i = 0; i < costumers.size(); i++) {
            if (costumers.get(i).getId().equals(id)) {
                costumer = costumers.get(i);
                break;
            }
        }
        return costumer;
    }

    public static String searchCostumerByName(ArrayList<Costumer> costumers, String name) {
        String costumer = "We don't have costumer named: " + name;
        for (int i = 0; i < costumers.size(); i++) {
            if (costumers.get(i).getName().equals(name)) {
                costumer = costumers.get(i).toString();
                break;
            }
        }
        return costumer;
    }

    public static String searchCostumerByIdInString(ArrayList<Costumer> costumers, String id) {
        String costumer = "We don't have costumer with ID of: " + id;
        for (int i = 0; i < costumers.size(); i++) {
            if (costumers.get(i).getId().equals(id)) {
                costumer = costumers.get(i).toString();
                break;
            }
        }
        return costumer;
    }
}
