package model;

public class Product {
    private int id;
    private String name;
    private int stoc;

    public Product(){

    }

    public Product(int id, String name, int stoc){
        super();
        this.id = id;
        this.name = name;
        this.stoc = stoc;
    }

    public Product(String name, int stoc){
        super();
        this.name = name;
        this.stoc = stoc;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoc() {
        return this.stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", stoc=" + stoc + "]";
    }


}
