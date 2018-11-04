package org.richardliao.job.manager.domain;

public class StatisticsData {
    private Long average;
    private Long variance;

    public void setAverage(Long average) {
	this.average = average;
    }

    public Long getAverage() {
	return this.average;
    }
}
