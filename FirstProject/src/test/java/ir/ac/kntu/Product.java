package ir.ac.kntu;
import java.util.ArrayList;

public class Product {
    private String name;
    private double weight;
    private Costumer receiver;
    private Branch sender;
    private City startingCity;
    private PostSituation postSituation;
    private Date sendTime;
    private Date receiveTime;
    private PostWay postWay;
    private SendingWay sendWay;
    private City destinationCity;

    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product(String name, Costumer receiver, Branch sender, City startingCity, City destinationCity,
                   double weight, Date sendTime, Date receiveTime, PostWay postWay, SendingWay sendWay,
                   PostSituation postSituation) {
        this.name = name;
        this.receiver = receiver;
        this.sender = sender;
        this.startingCity = startingCity;
        this.destinationCity = destinationCity;
        this.weight = weight;
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
        this.postWay = postWay;
        this.sendWay = sendWay;
        this.postSituation = postSituation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReceiver(Costumer receiver) {
        this.receiver = receiver;
    }

    public void setSender(Branch sender) {
        this.sender = sender;
    }

    public void setStartingCity(City startingCity) {
        this.startingCity = startingCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public void setPostWay(PostWay postWay) {
        this.postWay = postWay;
    }

    public void setSendWay(SendingWay sendWay) {
        this.sendWay = sendWay;
    }

    public void setPostSituation(PostSituation postSituation) {
        this.postSituation = postSituation;
    }

    //Getter

    public String getName() {
        return name;
    }

    public Costumer getReceiver() {
        return receiver;
    }

    public Branch getSender() {
        return sender;
    }

    public City getStartingCity() {
        return startingCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public double getWeight() {
        return weight;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public PostWay getPostWay() {
        return postWay;
    }

    public SendingWay getSendWay() {
        return sendWay;
    }

    public PostSituation getPostSituation() {
        return postSituation;
    }

    public static void searchByDestinationCity(ArrayList<Product> products, String city) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getDestinationCity().getName().equals(city)) {
                count++;
                System.out.println(products.get(i).toString());
            }
        }
        if (count == 0)
            System.out.println("We Don't have any Product with this Destination!");
    }

    public static void searchByStartingCity(ArrayList<Product> products, String city) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getStartingCity().getName().equals(city)) {
                count++;
                System.out.println(products.get(i).toString());
            }
        }
        if (count == 0)
            System.out.println("We Don't have any Product with this Starting City!");
    }

    ////////////////
    public static void filterBySentCon(ArrayList<Product> products) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPostSituation().equals(PostSituation.POSTED)) {
                count++;
                System.out.println(products.get(i).toString());
            }
        }
        if (count == 0)
            System.out.println("We Don't have any sent Products!");
    }

    public static void filterByReceivedCon(ArrayList<Product> products) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPostSituation().equals(PostSituation.RECEIVED)) {
                count++;
                System.out.println(products.get(i).toString());
            }
        }
        if (count == 0)
            System.out.println("We Don't have any received Products!");
    }

    public static void filterByInStockCon(ArrayList<Product> products) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPostSituation().equals(PostSituation.IN_STOCK)) {
                count++;
                System.out.println(products.get(i).toString());
            }
        }
        if (count == 0)
            System.out.println("We Don't have any In-Stock Products!");
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", receiver=" + receiver +
                ", sender=" + sender +
                ", \nstartingCity=" + startingCity +
                ", postSituation=" + postSituation +
                ", sendTime=" + sendTime +
                ", \nreceiveTime=" + receiveTime +
                ", postWay=" + postWay +
                ", sendWay=" + sendWay +
                ", destinationCity=" + destinationCity +
                '}';
    }
}
