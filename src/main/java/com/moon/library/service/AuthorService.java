package com.moon.library.service;

import com.moon.library.model.Author;
import java.util.List;

public interface AuthorService {

    Author save(Author s);

    List<Author> findAll();

    Author findById(long id);

    Author update(Author t);

    void delete(Author t);

    void deleteById(long id);
}
