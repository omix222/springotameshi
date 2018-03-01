package com.example.takahashi.springotamashi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COUNT")
public class Counter {
	@Id
	String id;
	@Column
	Integer count;

	public Counter(String id, Integer count) {
		super();
		this.id = id;
		this.count = count;
	}

	public Counter() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
