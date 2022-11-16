package ExampleTwo.looselyCoupled.entity;

import java.math.BigDecimal;

public class Product_l {

    private String name;
    private BigDecimal valorTotal;

    public Product_l(String name, BigDecimal valorTotal) {
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
