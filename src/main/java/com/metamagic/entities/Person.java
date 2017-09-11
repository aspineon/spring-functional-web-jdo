

package com.metamagic.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 * @author ketangote
 *
 */
@PersistenceCapable(table="person")
public class Person {

	@Persistent
	private  String name;

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private Integer id;

	public Person(){
		
	}
	
	public Person(String name) {
		super();
		this.name = name;
	
	}
	
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	
	
	
}
