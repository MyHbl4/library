package com.moon.library.service.impl;

import com.moon.library.error.NotFoundException;
import com.moon.library.error.ValidationException;
import com.moon.library.model.Product;
import com.moon.library.repository.ProductRepository;
import com.moon.library.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("404 NotFound"));
    }

    @Override
    public Product update(Product product) {
        Product oldEntity = findById(product.getId());
        oldEntity.setName(product.getName());
        oldEntity.setAuthor(product.getAuthor());
        oldEntity.setGenre(product.getGenre());
        oldEntity.setPublisher(product.getPublisher());
        oldEntity.setPageCount(product.getPageCount());
        oldEntity.setPublishDate(product.getPublishDate());
        oldEntity.setContent(product.getContent());
        return save(oldEntity);
    }

    @Override
    public void delete(Product product) {
        findById(product.getId());
        try {
            productRepository.delete(product);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public List<Product> findAllProductsByParam(String name, String author, String publisher) {
        return productRepository.findAllProductsByParam(name, author, publisher);
    }
}
