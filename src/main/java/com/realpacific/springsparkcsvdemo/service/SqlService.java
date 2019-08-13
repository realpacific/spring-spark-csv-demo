package com.realpacific.springsparkcsvdemo.service;

import com.realpacific.springsparkcsvdemo.entities.DataList;

import java.util.List;

public interface SqlService {
    void saveEvent(DataList data);

    List<DataList> retrieveAllEvents();
}
