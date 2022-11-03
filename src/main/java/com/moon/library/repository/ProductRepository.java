package com.moon.library.repository;

import com.moon.library.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select c from Product c where (c.name like :name or :name IS NULL) and (c.author.name like :author or :author IS NULL) and (c.publisher.name like :publisher or :publisher IS NULL)")
    List<Product> findAllProductsByParam(@Param("name") String name,
        @Param("author") String author,
        @Param("publisher") String publisher);

}
