package com.spartanwrath.restController;


import com.spartanwrath.model.Product;
import com.spartanwrath.service.ImageService;
import com.spartanwrath.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static com.spartanwrath.service.ImageService.FILES_FOLDER;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    /*private static final String PRODUCTS_FOLDER = "products";*/

    @Autowired
    private ProductService productServ;

    @Autowired
    private ImageService imageServ;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String category) {
        if (category != null) {
            List<Product> products = productServ.getProductsByCategory(category);
            if (!products.isEmpty()) {
                return ResponseEntity.ok().body(products);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.ok().body(productServ.getAllProducts());
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable long id) {
        Optional<Product> product = productServ.getProductById(id);
        if (product.isPresent()){
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        if (product.getImagen() == null || product.getImagen().isEmpty()){
            product.setImagen("../../images/DefaultProduct.jpg");
        }
        productServ.createProduct(product);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).body(product);
    }

    @PostMapping("/products/{id}/imagen")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException{
        Optional<Product> productOptional = productServ.getProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setImagen("../../images/" + imageFile.getOriginalFilename());

            productServ.updateProduct(product);

            // Guardar la imagen en la carpeta de recursos estáticos
            imageServ.saveImage(product.getImagen(), imageFile);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/products/{id}/imagen")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {
        Optional<Product> productOptional = productServ.getProductById(id);
        if (productOptional.isPresent()) {
            System.out.println(productOptional.get().getImagen());

            return this.imageServ.createResponseFromImage(String.valueOf(FILES_FOLDER), productOptional.get().getImagen());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product){
        Optional<Product> productOptional = productServ.getProductById(id);

        if (productOptional.isPresent()){
            Product _product = productOptional.get();
            _product.setNombre(product.getNombre());
            _product.setDescripcion(product.getDescripcion());
            _product.setPrecio(product.getPrecio());
            _product.setImagen(product.getImagen());
            _product.setCantidad(product.getCantidad());
            _product.setCategory(product.getCategory());
            productServ.updateProduct(_product);

            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<Product> deleteAll() {
        productServ.deleteAllProduct();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) throws IOException{
        Optional<Product> productOptional = productServ.getProductById(id);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            productServ.deleteProduct(id);
            if (product.getImagen() != null){
                this.imageServ.deleteImage(product.getImagen());
            }
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{id}/imagen")
    public ResponseEntity<Object> deleteImage(@PathVariable long id) throws IOException{
        Optional<Product> productOptional = productServ.getProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();


            this.imageServ.deleteImage(product.getImagen());
            product.setImagen("../../images/DefaultProduct.jpg");
            productServ.updateProduct(product);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
