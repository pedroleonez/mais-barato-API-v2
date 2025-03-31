package pedroleonez.mais_barato.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pedroleonez.mais_barato.dtos.product.ProductDTO;
import pedroleonez.mais_barato.exceptions.InvalidProductDataException;
import pedroleonez.mais_barato.exceptions.ProductNotFoundException;
import pedroleonez.mais_barato.models.ProductModel;
import pedroleonez.mais_barato.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // utility method
    private ProductModel mapDtoToProductModel(ProductModel productModel, ProductDTO dto) {
        if (dto.name() == null) {
            throw new InvalidProductDataException("Missing required product information.");
        }
        
        productModel.setName(dto.name());
        productModel.setPrice1(dto.price1());
        productModel.setSize1(dto.size1());
        productModel.setPrice2(dto.price2());
        productModel.setSize2(dto.size2());
        productModel.setUnit(dto.unit());
        
        return productModel;
    }

    // add product method
    public void addProduct(ProductDTO dto) {
        ProductModel productModel = mapDtoToProductModel(new ProductModel(), dto);
        productRepository.save(productModel);
    }

    // update product method
    public void updateProduct(Long id, ProductDTO dto) {
        ProductModel productModel = productRepository.findById(id)
                .orElseThrow(() -> new InvalidProductDataException("Product not found."));
        
        productModel = mapDtoToProductModel(productModel, dto);
        productRepository.save(productModel);
    }

    // delete product method
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found.");
        }
        
        productRepository.deleteById(id);
    }

    // list products method
    public List<ProductDTO> listProducts() {
        List<ProductModel> products = productRepository.findAll();
        
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found in the database.");
        }

        return products.stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice1(),
                        product.getSize1(),
                        product.getPrice2(),
                        product.getSize2(),
                        product.getUnit()
                ))
                .toList();
    }

    // get product by id method
    public ProductDTO getProductById(Long id) {
        ProductModel productModel = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));
        
        return new ProductDTO(
                productModel.getId(),
                productModel.getName(),
                productModel.getPrice1(),
                productModel.getSize1(),
                productModel.getPrice2(),
                productModel.getSize2(),
                productModel.getUnit()
        );
    }

}
