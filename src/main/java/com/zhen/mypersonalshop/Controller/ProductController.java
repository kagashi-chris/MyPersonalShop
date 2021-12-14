package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/products")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product)
    {
        Product p = productService.saveOrCreateProduct(product);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(value = {"/products/{productId}"})
    public ResponseEntity<?> getProduct(@PathVariable int productId)
    {
        Optional<Product> product = productService.getProduct(productId);
        if(product.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 product not in database!");
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
}
