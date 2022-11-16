package ExampleTwo.tighlyCoupled;

import java.math.BigDecimal;

public class Product_t {

    private String name;
    private BigDecimal valorTotal;

    public Product_t(String name, BigDecimal valorTotal) {
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
