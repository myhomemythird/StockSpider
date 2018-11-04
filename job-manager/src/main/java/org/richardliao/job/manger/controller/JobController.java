package org.richardliao.job.manager.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.richardliao.job.manager.domain.Job;
import org.richardliao.job.manager.db.JobRepository;
import org.richardliao.job.manager.CommonResponce;

@RestController
@RequestMapping(value="/job", produces="application/json")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value="/submit", method=POST)
    public Object submitJob(Job job) {
        jobRepository.save(job);
	return new CommonResponce(0, "submitted");
    }

    @RequestMapping(value="/{id}/stop", method=POST)
    public Object stopJob(@PathVariable("id") String id, @QueryParam("t") String t) {
	return new CommonResponce(0, "Stopped: " + id + ", " + t);
    }

    @RequestMapping(value="/{id}", method=DELETE)
    public Object deleteJob(@PathVariable("id") String id) {
	return new CommonResponce(0, "Deleted: " + id);
    }

    @RequestMapping(value="/list", method=GET)
    public Object jobList() {
        List<Job> res = jobRepository.findList();
	return new CommonResponce(0, res);
    }

    @RequestMapping(value="/{id}/details", method=GET)
    public Object jobDetails(@PathVariable("id") String id) {
        Job job = jobRepository.findOne(id);
	return new CommonResponce(0, job);
    }
}
