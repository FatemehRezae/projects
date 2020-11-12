package ir.ac.kntu;

public class Menus {
    public void mainMenu() {
        System.out.println("1-Make a new Branch\n2-Make a Costumer\n3-Make a city" +
                "\n4-Make a product\n5-Send and receive a product\n6-Order Tracking\n7-Search a Costumer" +
                "\n8-search product by destination city/Starting City\n9-Filter Products by their conditions");
    }

    public void sendingWaysMenu() {
        System.out.println("Enter :\n1 for ground shipping \n2 for air freight\n3 for shipping by the sea");
    }

    public void postWaysMenu() {
        System.out.println("Enter:\n 1 for normal Delivery \n2 for special delivery");
    }
}
