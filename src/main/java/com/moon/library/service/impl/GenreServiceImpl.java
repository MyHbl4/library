package com.moon.library.service.impl;

import com.moon.library.error.NotFoundException;
import com.moon.library.error.ValidationException;
import com.moon.library.model.Genre;
import com.moon.library.repository.GengreRepository;
import com.moon.library.service.GenreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GengreRepository gengreRepository;

    @Override
    public Genre save(Genre genre) {
        try {
            return gengreRepository.save(genre);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public List<Genre> findAll() {
        return gengreRepository.findAll();
    }

    @Override
    public Genre findById(long id) {
        return gengreRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("404 NotFound"));
    }

    @Override
    public Genre update(Genre genre) {
        Genre oldEntity = findById(genre.getId());
        oldEntity.setName(genre.getName());
        return save(oldEntity);
    }

    @Override
    public void delete(Genre genre) {
        findById(genre.getId());
        try {
            gengreRepository.delete(genre);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        try {
            gengreRepository.deleteById(id);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }
}
