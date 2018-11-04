package org.richardliao.job.manager.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.richardliao.job.manager.domain.Job;

public interface JobRepository extends MongoRepository<Job, String> {
    Job save(Job job);

    Job findOne(String id);

    @Query("{'delereFlag': 'N'}")
    List<Job> findList();
}
