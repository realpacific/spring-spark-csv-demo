package com.realpacific.springsparkcsvdemo.respositories;

import com.realpacific.springsparkcsvdemo.entities.DataList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlRepository extends JpaRepository<DataList, Integer> {

}
