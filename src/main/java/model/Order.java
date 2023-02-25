package model;

public class Order {
    private int id;
    private int idClient;
    private int idProduct;
    private int quantity;

    public Order(){

    }

    public Order(int idOrder, int idClient, int idProduct, int quantity){
        super();
        this.id = idOrder;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Order(int idClient, int idProduct, int quantity){
        super();
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int idOrder) {
        this.id = idOrder;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Order [idOrder=" + id + ", idClient=" + idClient + ", idProduct=" + idProduct + ", quantity=" + quantity + "]";
    }

}
