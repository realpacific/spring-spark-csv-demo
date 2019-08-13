package com.realpacific.springsparkcsvdemo.service;

import com.realpacific.springsparkcsvdemo.entities.DataList;
import com.realpacific.springsparkcsvdemo.respositories.SqlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SqlServiceImp implements SqlService {

    private final SqlRepository repository;

    @Override
    public void saveEvent(DataList data) {
        repository.save(data);
    }

    @Override
    public List<DataList> retrieveAllEvents() {
        return repository.findAll();
    }
}
