package com.moon.library.controller;

import com.moon.library.model.Author;
import com.moon.library.service.AuthorService;
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
@RequestMapping(value = "/author")
@Slf4j
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(path = "/{id}")
    public Author findById(@PathVariable(name = "id") long id) {
        return authorService.findById(id);
    }

    @GetMapping()
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @PostMapping()
    public Author save(@Valid @RequestBody Author author) {
        return authorService.save(author);
    }

    @PutMapping()
    public Author update(@Valid @RequestBody Author author) {
        return authorService.update(author);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        authorService.deleteById(id);
    }
}
