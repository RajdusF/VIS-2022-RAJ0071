package DataLayer;

public class Vehicle {
    private int vehicle_id;
    private String title;
    private String type;
    private String selling_price;
    private String production_price;

    public Vehicle(int vehicle_id, String title, String type, String selling_price, String production_price) {
        this.vehicle_id = vehicle_id;
        this.title = title;
        this.type = type;
        this.selling_price = selling_price;
        this.production_price = production_price;
    }
}
