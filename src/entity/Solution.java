package entity;

public class Solution {
	
	//POLE KLASY
	private Integer id;
	private String created;
	private String updated;
	private String description;
	private Integer excerciseId;
	private Integer userId;
	
	//KONSTRUKTOR
	public Solution(Integer id, String created, String updated, String description, Integer excerciseId,
			Integer userId) {
		this.id = id;
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.excerciseId = excerciseId;
		this.userId = userId;
	}
	
	//KONSTRUKTOR DOMYSLNY
	public Solution(){
	}
	
	//GETTERY SETTERY
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getExcerciseId() {
		return excerciseId;
	}
	public void setExcerciseId(Integer excerciseId) {
		this.excerciseId = excerciseId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	//TO STRING METHOD
	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", excerciseId=" + excerciseId + ", userId=" + userId + "]";
	}
	
	
	
	
}