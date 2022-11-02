package com.moon.library.service.impl;

import com.moon.library.model.Genre;
import com.moon.library.repository.GengreRepository;
import com.moon.library.service.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GengreRepository gengreRepository;

    @Override
    public Genre save(Genre genre) {
        return gengreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return gengreRepository.findAll();
    }

    @Override
    public Genre findById(long id) {
        return gengreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre update(Genre genre) {
        return gengreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        gengreRepository.delete(genre);
    }

    @Override
    public void deleteById(long id) {
        gengreRepository.deleteById(id);
    }
}
