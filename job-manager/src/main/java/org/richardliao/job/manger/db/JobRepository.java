package org.richardliao.job.manager.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.richardliao.job.manager.domain.Job;

public interface JobRepository extends MongoRepository<Job, String> {
    int save(Job job);

    Job findOne(String id);

    @Query("{'delereFlag': 'N'}")
    List<Job> findList();
}
