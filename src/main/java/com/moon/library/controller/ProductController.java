package com.moon.library.controller;

import com.moon.library.model.Product;
import com.moon.library.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path="/{id}")
    public Product findById(@PathVariable(name = "id") long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping
    public Product save(Product product){
        return productService.save(product);
    }

    @PutMapping()
    public Product update(@Valid @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        productService.deleteById(id);
    }
}
