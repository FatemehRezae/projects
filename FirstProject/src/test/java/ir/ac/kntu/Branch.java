package ir.ac.kntu;
import java.util.ArrayList;
public class Branch {
    private String code;
    private City city;
    private int employees;

    public Branch(String code) {
        this.code = code;
    }

    public Branch(String code, City city, int employees) {
        this.code = code;
        this.city = city;
        this.employees = employees;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public String getCode() {
        return code;
    }

    public City getCity() {
        return city;
    }

    public int getEmployees() {
        return employees;
    }

    public static Branch searchByCode(ArrayList<Branch> branches, String code) {
        Branch branch = null;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getCode().equals(code)) {
                branch = branches.get(i);
                break;
            }
        }
        return branch;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "code='" + code + '\'' +
                ", city=" + city +
                ", employees=" + employees +
                '}';
    }
}
