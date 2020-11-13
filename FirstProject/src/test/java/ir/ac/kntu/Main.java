package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Menus menus = new Menus();
    private static ArrayList<Branch> branches = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Costumer> costumers = new ArrayList<>();
    private static ArrayList<City> cities = new ArrayList<>();
    private static String string;
    private static String string1;
    private static int a = 1;
    private static int b;

    public static void start() {
        City tehran = new City("Tehran", 0, 0);
        City mashhad = new City("Mashhad", 1, 1);
        City shiraz = new City("Shiraz", 2, 2);
        cities.add(tehran);
        cities.add(mashhad);
        cities.add(shiraz);
        Costumer sara = new Costumer("Sara", "11001");
        Costumer ali = new Costumer("ali", "51200");
        costumers.add(ali);
        costumers.add(sara);
        Branch branch = new Branch("0", tehran, 10);
        branches.add(branch);
        Product product = new Product("first Product", sara, branch, tehran, shiraz, 2.5,
                new Date(1399, 9, 1), new Date(1399, 9, 3),
                PostWay.SPECIAL_DELIVERY, SendingWay.GROUND_SHIPPING, PostSituation.IN_STOCK, 3000);
        products.add(product);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start();
        System.out.println("WELCOME!!");
        while (a != 0) {
            menus.mainMenu();
            a = scanner.nextInt();
            if (a == 1) {
                makeABranch(scanner);
            } else if (a == 2) {
                makeACostumer(scanner);
            } else if (a == 3) {
                makeACity(scanner);
            } else if (a == 4) {
                makeAProduct(scanner);
            } else if (a == 5) {
                receiveAndSendTimeManagement(scanner);
            } else if (a == 6) {
                orderTracking(scanner);
            } else if (a == 7) {
                searchACostumer(scanner);
            } else if (a == 8) {
                searchProductByDesOrStCity(scanner);
            } else if (a == 9) {
                filterByCondition(scanner);
            }
        }
        scanner.close();
    }

    public static void makeABranch(Scanner scanner) {
        b = -1;
        System.out.println("Enter branch code");
        string = scanner.next();
        Branch branch = new Branch(string);
        System.out.println("Enter City name");
        string = scanner.next();
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(string)) {
                b = i;
                break;
            }
        }
        if (b == -1) {
            System.out.println("We don't have this city.Make the City First.");
        } else {
            System.out.println("Enter Employee number");
            string = scanner.next();
            branch.setCity(cities.get(b));
            branch.setEmployees(Integer.parseInt(string));
            branches.add(branch);
        }
    }

    public static void makeACostumer(Scanner scanner) {
        System.out.println("Enter Costumer Name");
        string = scanner.next();
        System.out.println("Enter Costumer ID");
        string1 = scanner.next();
        Costumer costumer = new Costumer(string, string1);
        if (Costumer.searchCostumerByID(costumers, string1) == null)
            costumers.add(costumer);
        else System.out.println("This Costumer already Exist\n*****");
    }

    public static void makeACity(Scanner scanner) {
        System.out.println("Enter City Name");
        string = scanner.next();
        City city = City.searchByName(cities, string);
        if (city == null) {
            city = new City(string);
            System.out.println("Enter City Coordinates: x & y");
            string = scanner.next();
            string1 = scanner.next();
            city.setCoordinates(new Coordinates(Double.parseDouble(string), Double.parseDouble(string1)));
            cities.add(city);
        } else System.out.println("We have this City");
    }

    public static void makeAProduct(Scanner scanner) {
        if (cities.size() < 2 && branches.size() < 1 && costumers.size() < 2)
            System.out.println("You Can't Make a product!");
        else {
            System.out.println("Enter name of the product");
            string = scanner.next();
            System.out.println("Enter weight of the product");
            string1 = scanner.next();
            Product product = new Product(string, Double.parseDouble(string1));
            products.add(product);
            System.out.println("Enter Costumer ID");
            string = scanner.next();
            Costumer costumer = Costumer.searchCostumerByID(costumers, string);
            if (costumer != null) {
                product.setReceiver(costumer);
                costumer.addAProduct();
                System.out.println("Enter Branch Code");
                string = scanner.next();
                Branch branch = Branch.searchByCode(branches, string);
                if (branch != null) {
                    product.setSender(branch);
                    product.setStartingCity(branch.getCity());
                    product.setPostSituation(PostSituation.IN_STOCK);
                    setDate(scanner, product);
                    ways(scanner, product);
                    System.out.println("Enter Destination City's name");
                    string = scanner.next();
                    City city = City.searchByName(cities, string);
                    if (city != null) {
                        product.setDestinationCity(city);
                        System.out.println("Enter cost of the product:");
                        string = scanner.next();
                        if (costumer.getShopsNumber() > 5) {
                            product.setCost(Double.parseDouble(string) - Double.parseDouble(string) / 10);
                        } else product.setCost(Double.parseDouble(string));
                    } else {
                        System.out.println("We don't have This City.");
                    }
                } else {
                    System.out.println("We don't have a branch with this code!\n");
                    products.remove(product);
                }
            } else {
                System.out.println("We don't have a costumer with this ID!\n");
                products.remove(product);
            }
        }
    }

    public static void setDate(Scanner scanner, Product product) {
        System.out.println("Enter send Time: Day & Month & year");
        b = scanner.nextInt();
        string1 = scanner.next();
        string = scanner.next();
        Date date = new Date(Integer.parseInt(string), Integer.parseInt(string1), b);
        product.setSendTime(date);
        System.out.println("Enter receive Time: Day & Month & year");
        b = scanner.nextInt();
        string1 = scanner.next();
        string = scanner.next();
        date = new Date(Integer.parseInt(string), Integer.parseInt(string1), b);
        product.setReceiveTime(date);
    }

    public static void ways(Scanner scanner, Product product) {
        menus.sendingWaysMenu();
        b = scanner.nextInt();
        if (b == 1 || b == 2 || b == 3) {
            if (b == 1)
                product.setSendWay(SendingWay.GROUND_SHIPPING);
            else if (b == 2)
                product.setSendWay(SendingWay.AIR_FREIGHT);
            else
                product.setSendWay(SendingWay.SHIPPING_BY_SEA);
            menus.postWaysMenu();
            b = scanner.nextInt();
            if (b == 1 || b == 2) {
                if (b == 1)
                    product.setPostWay(PostWay.NORMAL);
                else product.setPostWay(PostWay.SPECIAL_DELIVERY);
            } else {
                System.out.println("Wrong number. Please try again");
                ways(scanner, product);
            }
        } else {
            System.out.println("Wrong number. Please try again");
            ways(scanner, product);
        }
    }

    public static void receiveAndSendTimeManagement(Scanner scanner) {
        System.out.println("Enter Today's Date: Day & Month & year");
        b = scanner.nextInt();
        string1 = scanner.next();
        string = scanner.next();
        Date date = new Date(Integer.parseInt(string), Integer.parseInt(string1), b);
        for (Product product : products) {
            if (product.getSendTime().compareTo(date) <= 0) {
                product.setPostSituation(PostSituation.POSTED);
            }
            if (product.getReceiveTime().compareTo(date) <= 0) {
                product.setPostSituation(PostSituation.RECEIVED);
            }
        }
    }

    public static void orderTracking(Scanner scanner) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + "- " + products.get(i).getName());
        }
        string = scanner.next();
        if (Integer.parseInt(string) >= 0 && Integer.parseInt(string) < products.size()) {
            System.out.println(products.get(Integer.parseInt(string)).getPostSituation());
        } else {
            System.out.println("Wrong number. Try again.");
            orderTracking(scanner);
        }
    }

    public static void searchACostumer(Scanner scanner) {
        System.out.println("Enter 1 for search By Name\n2 for search by ID");
        b = scanner.nextInt();
        if (b == 1) {
            System.out.println("Enter the name");
            string = scanner.next();
            System.out.println(Costumer.searchCostumerByName(costumers, string));
        }
        if (b == 2) {
            System.out.println("Enter the ID");
            string = scanner.next();
            System.out.println(Costumer.searchCostumerByIdInString(costumers, string));
        }
        if (b > 2 || b < 1) {
            System.out.println("Wrong number!");
        }
    }

    public static void searchProductByDesOrStCity(Scanner scanner) {
        System.out.println("Enter 1 for search By Starting City\n2 for search by Destination City");
        b = scanner.nextInt();
        if (b == 1) {
            System.out.println("Enter City's name");
            string = scanner.next();
            Product.searchByStartingCity(products, string);
        }
        if (b == 2) {
            System.out.println("Enter City's Name");
            string = scanner.next();
            Product.searchByDestinationCity(products, string);
        }
        if (b > 2 || b < 1) {
            System.out.println("Wrong number!");
        }
    }

    public static void filterByCondition(Scanner scanner) {
        System.out.println("Enter 1 for sent products\n2 for in-stock product\n3for received products");
        b = scanner.nextInt();
        if (b == 1) {
            Product.filterBySentCon(products);
        }
        if (b == 2) {
            Product.filterByInStockCon(products);
        }
        if (b == 3) {
            Product.filterByReceivedCon(products);
        }
        if (b > 3 || b < 1) {
            System.out.println("Wrong number!");
        }
    }
}
