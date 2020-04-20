package com.zoomanagement.springmvc.model;

public class Pen {
	
	private long id;
    private String penName;
    
    public Pen(){
		id=0;
	}
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPenName() {
		return penName;
	}
	public void setPenName(String penName) {
		this.penName = penName;
	}
	public Pen(long id, String penName) {
		super();
		this.id = id;
		this.penName = penName;
	}
	@Override
	public String toString() {
		return "Pen [id=" + id + ", penName=" + penName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((penName == null) ? 0 : penName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (id != other.id)
			return false;
		if (penName == null) {
			if (other.penName != null)
				return false;
		} else if (!penName.equals(other.penName))
			return false;
		return true;
	}
 

}
