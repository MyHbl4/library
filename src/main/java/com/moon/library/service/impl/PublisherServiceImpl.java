package com.moon.library.service.impl;

import com.moon.library.error.NotFoundException;
import com.moon.library.error.ValidationException;
import com.moon.library.model.Publisher;
import com.moon.library.repository.PublisherRepository;
import com.moon.library.service.PublisherService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public Publisher save(Publisher publisher) {
        try {
            return publisherRepository.save(publisher);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(long id) {
        return publisherRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("404 NotFound"));
    }

    @Override
    public Publisher update(Publisher publisher) {
        Publisher oldEntity = findById(publisher.getId());
        oldEntity.setName(publisher.getName());
        return save(oldEntity);
    }

    @Override
    public void delete(Publisher publisher) {
        findById(publisher.getId());
        try {
            publisherRepository.delete(publisher);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        try {
            publisherRepository.deleteById(id);
        } catch (Exception e) {
            throw new ValidationException("400 Bad Request");
        }
    }
}
