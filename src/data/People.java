package data;

public class People {

	private int id,age;
	private String relation,fname,lname,sex,title;
	public People(int id, String title, int age,String relation, String fname, String lname, String sex) {
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.relation = relation;
		this.fname = fname;
		this.lname = lname;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("People [id=");
		builder.append(id);
		builder.append(", age=");
		builder.append(age);
		builder.append(", Relation=");
		builder.append(relation);
		builder.append(", Fname=");
		builder.append(fname);
		builder.append(", Lname=");
		builder.append(lname);
		builder.append(", Sex=");
		builder.append(sex);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
