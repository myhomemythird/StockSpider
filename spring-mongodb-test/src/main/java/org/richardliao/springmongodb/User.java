package org.richardliao.springmongodb;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;

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
    public void setAge(Integer age) {
	this.age = age;
    }
    public Integer getAge() {
	return this.age;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("User [");
	sb.append("id=").append(this.id).append(", ");
	sb.append("name=").append(this.name).append(", ");
	sb.append("age=").append(this.age);
	sb.append("]");
	return sb.toString();
    }
}
