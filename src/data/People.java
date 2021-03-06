package data;

public class People {

	private int id, age;
	private String relation, fname, lname, sex, title;

	public People(){
		
	}
	
	public People(int age, String relation, String fname, String lname) {
		this.age = age;
		this.relation = relation;
		this.fname = fname;
		this.lname = lname;
	}

	public People(int id, int age, String relation, String fname, String lname, String sex) {
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.relation = relation;
		this.fname = fname;
		this.lname = lname;
		
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
		builder.append(relation +",");
		builder.append(fname+",");
		builder.append(lname);
		builder.append(",");
		builder.append(age);
		builder.append(System.getProperty("line.separator"));
		return (builder.toString());
	}

}
