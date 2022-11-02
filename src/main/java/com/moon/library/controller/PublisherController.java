package com.moon.library.controller;

import com.moon.library.model.Publisher;
import com.moon.library.service.PublisherService;
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
@RequestMapping(value = "/publisher")
@Slf4j
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping(path = "/{id}")
    public Publisher findById(@PathVariable(name = "id") long id) {
        return publisherService.findById(id);
    }

    @GetMapping
    public List<Publisher> findAll() {
        return publisherService.findAll();
    }

    @PostMapping
    public Publisher save(Publisher publisher) {
        return publisherService.save(publisher);
    }

    @PutMapping()
    public Publisher update(@Valid @RequestBody Publisher publisher) {
        return publisherService.update(publisher);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        publisherService.deleteById(id);
    }
}
