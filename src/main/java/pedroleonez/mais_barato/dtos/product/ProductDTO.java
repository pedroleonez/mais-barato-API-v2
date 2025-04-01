package pedroleonez.mais_barato.dtos.product;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String name,
        BigDecimal price1,
        BigDecimal size1,
        BigDecimal price2,
        BigDecimal size2
) {

}
