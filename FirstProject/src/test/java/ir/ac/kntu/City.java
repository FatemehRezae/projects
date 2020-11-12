package ir.ac.kntu;
import java.util.ArrayList;

public class City {
    private String name;
    private Coordinates coordinates;

    public City(String name, double x, double y) {
        this.name = name;
        coordinates = new Coordinates(x, y);
    }

    public City(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public static City searchByName(ArrayList<City> cities, String name) {
        City city = null;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(name)) {
                city = cities.get(i);
                break;
            }
        }
        return city;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
