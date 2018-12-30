package org.richardliao.job.manager.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Job {
    @Id
    private String id;
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String owner;
    private String creator;
    private String createTime;
    private String deleteFlag;
    private String status;
    private String startUrl;
    private String dataExtractor;
    private StatisticsData statisData;

    public void setId(String id) {
	this.id = id;
    }

    public String getId() {
	return this.id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return this.name;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDescription() {
	return this.description;
    }

    public void setStartTime(String startTime) {
	this.startTime = startTime;
    }

    public String getStartTime() {
	return this.startTime;
    }

    public void setEndTime(String endTime) {
	this.endTime = endTime;
    }

    public String getEndTime() {
	return this.endTime;
    }

    public void setOwner(String owner) {
	this.owner = owner;
    }

    public String getOwner() {
	return this.owner;
    }

    public void setCreator(String creator) {
	this.creator = creator;
    }

    public String getCreator() {
	return this.creator;
    }

    public void setCreateTime(String createTime) {
	this.createTime = createTime;
    }

    public String getCreateTime() {
	return this.createTime;
    }

    public void setDeleteFlag(String deleteFlag) {
	this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() {
	return this.deleteFlag;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStartUrl(String startUrl) {
	this.startUrl = startUrl;
    }

    public String getStartUrl() {
	return this.startUrl;
    }

    public void setDataExtractor(String dataExtractor) {
	this.dataExtractor = dataExtractor;
    }

    public String getDataExtractor() {
	return this.dataExtractor;
    }

    public void setStatisData(StatisticsData statisData) {
	this.statisData = statisData;
    }

    public StatisticsData getStatisData() {
	return this.statisData;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Job [");
	sb.append("id=").append(this.id).append(", ");
	sb.append("name=").append(this.name).append(", ");
	sb.append("description=").append(this.description).append(", ");
	sb.append("startTime=").append(this.startTime);
	sb.append("]");
	return sb.toString();
    }
}
