package model;

public class Client {
    private int id;
    private String name;
    private String adresa;

    public Client() {

    }

    public Client(int id, String name, String adresa)
    {
        super();
        this.id = id;
        this.name = name;
        this.adresa = adresa;
    }

    public Client(String name, String adresa)
    {
        super();
        this.name = name;
        this.adresa = adresa;
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

    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String address) {
        this.adresa = address;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", address=" + adresa + "]";
    }
}
