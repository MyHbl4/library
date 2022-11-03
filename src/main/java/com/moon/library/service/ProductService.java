package com.moon.library.service;

import com.moon.library.model.Product;
import java.util.List;

public interface ProductService {

    Product save(Product s);

    List<Product> findAll();

    Product findById(long id);

    Product update(Product t);

    void delete(Product t);

    void deleteById(long id);

    List<Product> findAllProductsByParam(String name, String author, String publisher);
}
