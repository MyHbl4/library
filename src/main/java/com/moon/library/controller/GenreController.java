package com.moon.library.controller;

import com.moon.library.model.Genre;
import com.moon.library.service.GenreService;
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
@RequestMapping(value = "/genre")
@Slf4j
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping(path = "/{id}")
    public Genre findById(@PathVariable(name = "id") long id) {
        return genreService.findById(id);
    }

    @GetMapping
    public List<Genre> findAll() {
        return genreService.findAll();
    }

    @PostMapping
    public Genre save(Genre genre) {
        return genreService.save(genre);
    }

    @PutMapping()
    public Genre update(@Valid @RequestBody Genre genre) {
        return genreService.update(genre);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        genreService.deleteById(id);
    }
}
