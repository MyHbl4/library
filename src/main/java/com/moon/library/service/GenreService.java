package com.moon.library.service;

import com.moon.library.model.Genre;
import java.util.List;

public interface GenreService {

    Genre save(Genre s);

    List<Genre> findAll();

    Genre findById(long id);

    Genre update(Genre t);

    void delete(Genre t);

    void deleteById(long id);
}
