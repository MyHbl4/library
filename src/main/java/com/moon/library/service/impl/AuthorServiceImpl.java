package com.moon.library.service.impl;

import com.moon.library.error.NotFoundException;
import com.moon.library.error.ValidationException;
import com.moon.library.model.Author;
import com.moon.library.repository.AuthorRepository;
import com.moon.library.service.AuthorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        try {
            return authorRepository.save(author);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(long id) {
        return authorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("404 NotFound"));
    }

    @Override
    public Author update(Author author) {
        Author oldEntity = findById(author.getId());
        oldEntity.setName(author.getName());
        return save(oldEntity);
    }

    @Override
    public void delete(Author author) {
        findById(author.getId());
        authorRepository.delete(author);
        try {
            authorRepository.delete(author);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        try {
            authorRepository.deleteById(id);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }
}
