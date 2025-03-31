package pedroleonez.mais_barato.models;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;

    private BigDecimal price1;

    private BigDecimal size1;

    private BigDecimal price2;
    
    private BigDecimal size2;

    private String unit;

}
