package com.niit.Techno.MyREST;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Book")
public class Book {

	private String id;
	private String name;
	private String authorName;
	private int volumeNumber;
	private String publisher;
	
	@XmlElement(name="ID", required=true)
	public String getId()
	{
		return id;
		
	}
	public void setId(String id)
	{
		this.id=id;
	}
	
	@XmlElement(name="NAME")
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	
	@XmlElement(name="VOLUME")
	public int getVolumeNumber()
	{
		return volumeNumber;
	}
	public void setVolumeNumber(int VolumeNumber) 
	{
		this.volumeNumber=VolumeNumber;
		
	}
	@XmlElement(name="authorName")
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	@XmlTransient
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
