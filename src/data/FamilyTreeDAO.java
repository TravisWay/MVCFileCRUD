package data;

import java.util.List;



public interface FamilyTreeDAO {

	
	 public List<People> getPeopleByName(String name);
	  public List<People> getPeopleByRelation(String relation);
	  public People addPeople(People people);
	  public boolean killPeople(People people);
	  
	  public List<People> CurrentTree();
	 
	  
	//public void addFlashAttribute(People people, State state);
	
}
