package com.mddw.readers.THE_READERS.repository;

import com.mddw.readers.THE_READERS.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
