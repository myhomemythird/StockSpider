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
@RequestMapping(value="/job", consumes="application/json")
public class JobController {

    private JobRepository repo;

    @Autowired
    public JobController(JobRepository repo) {
	this.repo = repo;
    }

    @RequestMapping(value="/submit", method=POST)
    public Object submitJob(@RequestBody Job job) {
        Job res = repo.save(job);
	return new CommonResponce(0, "Job [" + res.getId() + "] submitted");
    }

    @RequestMapping(value="/{id}/stop", method=PUT)
    public Object stopJob(@PathVariable("id") String id, @QueryParam("type") String type) {
	if (null == id || "".equals(id.trim())) return new CommonResponce(0, "id is null");
	if (null == type || "".equals(type.trim())) return new CommonResponce(0, "type is null");
	Job jobDb = repo.findById(id);
	if (null == jobDb) return new CommonResponce(0, "Job not found");
	if ("0".equals(type.trim()))
	    jobDb.setStatus("Suspend");
	else if ("1".equals(type.trim()))
	    jobDb.setStatus("Stop");
	else
	    return new CommonResponce(0, "Type un-recognized");
	repo.save(jobDb);
	return new CommonResponce(0, "Stopped: " + id + ", " + type);
    }

    @RequestMapping(value="/{id}", method=DELETE)
    public Object deleteJob(@PathVariable("id") String id) {
	if (null == id || "".equals(id.trim())) return new CommonResponce(0, "id is null");
	Job jobDb = repo.findById(id);
	if (null == jobDb) return new CommonResponce(0, "Job not found");
	jobDb.setDeleteFlag("Y");
	repo.save(jobDb);
	return new CommonResponce(0, "Deleted: " + id);
    }

    @RequestMapping(value="/list", method=GET)
    public Object jobList() {
        List<Job> res = repo.findList();
	return new CommonResponce(0, res);
    }

    @RequestMapping(value="/{id}/details", method=GET)
    public Object jobDetails(@PathVariable("id") String id) {
	if (null == id || "".equals(id.trim())) return new CommonResponce(0, "id is null");
        Job job = repo.findById(id);
	if (null == job) return new CommonResponce(0, "Job not found");
	return new CommonResponce(0, job);
    }
}
