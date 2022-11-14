package ExampleTwo;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal valorTotal;

    public Product(String name, BigDecimal valorTotal) {
        this.name = name;
        this.valorTotal = valorTotal;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
