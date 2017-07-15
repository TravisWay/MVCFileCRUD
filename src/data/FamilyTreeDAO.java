package data;

import java.util.List;



public interface FamilyTreeDAO {

	
	 public List<People> getPeopleByName(String name);
	  public List<People> getPeopleByRelation(String relation);
	  public List<People> addPeople(People people);
	  public List<People> killPeople(People people);
	  
	  public List<People> CurrentTree();
	 
	  
	//public void addFlashAttribute(People people, State state);
	
}
