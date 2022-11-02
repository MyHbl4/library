package com.moon.library.service;

import com.moon.library.model.Publisher;
import java.util.List;

public interface PublisherService {

    Publisher save(Publisher s);

    List<Publisher> findAll();

    Publisher findById(long id);

    Publisher update(Publisher t);

    void delete(Publisher t);

    void deleteById(long id);
}
