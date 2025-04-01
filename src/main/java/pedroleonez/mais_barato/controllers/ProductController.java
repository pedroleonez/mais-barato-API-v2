package pedroleonez.mais_barato.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedroleonez.mais_barato.dtos.product.ProductDTO;
import pedroleonez.mais_barato.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // add product endpoint
    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO dto) {
        productService.addProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update product endpoint
    @PostMapping("/updade/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
        productService.updateProduct(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // delete product endpoint
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // list products endpoint
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> products = productService.listProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    // get product by id endpoint
    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    // get best option endpoint
    @GetMapping("/bestOption/{id}")
    public ResponseEntity<String> getBestOption(@PathVariable Long id) {
        String bestOption = productService.getBestOption(id);
        return ResponseEntity.status(HttpStatus.OK).body(bestOption);
    }
}
