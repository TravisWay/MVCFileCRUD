package data;

public class People {

	private int id, age;
	private String relation, fname, lname, sex, title;

	public People(){
		
	}
	public People(int id, int age, String relation, String fname, String lname, String sex) {
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.relation = relation;
		this.fname = fname;
		this.lname = lname;
		setTitle(relation);
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String relation) {
		if ((this.relation.equals("Grandmother")) || (this.relation.equals("Grandfather"))) {
			title = "Grandparent";
		} else if ((this.relation.equals("Mother")) || (this.relation.equals("Father"))) {
			title = "Parent";
		} else if ((this.relation.equals("Brother")) || (this.relation.equals("Sister"))) {
			title = "Sibling";
		} else if ((this.relation.equals("Son")) || (this.relation.equals("Daughter"))) {
			title = "Child";
		} else if ((this.relation.equals("Greatgrandfather")) || (this.relation.equals("Greatgrandmother"))) {
			title = "Greatgrandparent";
		} else if (this.relation.equals("Cousin")) {
			title = relation;
		} else if (this.relation.equals("Niece") || this.relation.equals("Nephew")) {
			title = relation;
		}

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
		builder.append(relation +", ");
		builder.append(fname+ " ");
		builder.append(lname);
		builder.append(", age=");
		builder.append(age);
		return (builder.toString());
	}

}
