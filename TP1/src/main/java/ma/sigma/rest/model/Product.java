package ma.sigma.rest.model;

public class Product {

    private Long id ;
    private String name;

    public Product() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
