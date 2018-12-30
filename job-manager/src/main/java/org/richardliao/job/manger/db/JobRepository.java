package org.richardliao.job.manager.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.richardliao.job.manager.domain.Job;

public interface JobRepository extends MongoRepository<Job, String> {
    Job findById(String id);
    @Query("{'deleteFlag': 'N'}")
    List<Job> findList();
}
