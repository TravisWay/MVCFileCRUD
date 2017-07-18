package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class FamilyTreeDAOImpl implements FamilyTreeDAO {

	private static final String FILE_NAME = "/WEB-INF/familytree.csv";
	private List<People> familymembers = new ArrayList<>();
	private List<People> searchresults = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	// Upon startup, reads the .csv to enter family members if they are
	// there(they are not in this case)
	@PostConstruct
	public void init() {
		try {
			FileWriter fw = new FileWriter((((wac.getServletContext()).getRealPath(FILE_NAME))));
			BufferedWriter bw = new BufferedWriter(fw);
			for (People people2 : familymembers) {
				bw.write(people2.toString());
				System.out.println("Done");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Searches the familymembers list for matches of first or last name and
	// gives the results list
	@Override
	public List<People> getPeopleByName(String name) {
		searchresults.clear();
		for (People people : familymembers) {
			if (((people.getFname().toLowerCase()).equals(name.toLowerCase()))
					|| ((people.getLname().toLowerCase()).equals(name.toLowerCase()))) {
				searchresults.add(people);
			}
		}
		return searchresults;
	}

	// Searches the familymembers list for Relation values with the one
	// specified.
	@Override
	public List<People> getPeopleByRelation(String relation) {
		searchresults.clear();
		for (People people : familymembers) {
			if ((people.getRelation() != null)) {
				if ((people.getRelation().contains(relation))) {
					searchresults.add(people);
				}
			}
		}
		return searchresults;
	}

	// Adds a member to the list and then overwrites the file containing the
	// list with the newly updated one.
	@Override
	public People addPeople(People people) {
		readFile();
		familymembers.add(people);
		System.out.println(familymembers);
		// File file = new
		// File(((wac.getServletContext()).getRealPath(FILE_NAME)));
		try {
			FileWriter fw = new FileWriter((((wac.getServletContext()).getRealPath(FILE_NAME))));
			BufferedWriter bw = new BufferedWriter(fw);
			for (People people2 : familymembers) {
				bw.write(people2.toString());
				System.out.println("Done");
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return people;
	}

	// Searches the list for the member with the matching data and deletes that
	// member from the list and rewrites the file.
	@Override
	public boolean killPeople(People people) {
		readFile();
		System.out.println(familymembers);
		boolean exists = false;
		Iterator<People> iter = familymembers.iterator();
		while (iter.hasNext()) {
			People people1 = iter.next();
			if ((people1.getFname()).toLowerCase().equals(people.getFname().toLowerCase())
					&& (people1.getLname().toLowerCase()).equals(people.getLname().toLowerCase()))
					 {
				exists = true;
				iter.remove();
				break;
			}
		}
		// File file = new
		// File(((wac.getServletContext()).getRealPath(FILE_NAME)));
		try {
			FileWriter fw = new FileWriter((((wac.getServletContext()).getRealPath(FILE_NAME))));
			BufferedWriter bw = new BufferedWriter(fw);
			for (People people2 : familymembers) {
				bw.write(people2.toString());
				System.out.println("Done");
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return exists;
	}

	// Returns the Search Results list
	public List<People> getSearchresults() {
		return searchresults;
	}

	// Returns the updated familymembers list
	@Override
	public List<People> CurrentTree() {
		System.out.println(familymembers);
		readFile();
		System.out.println(familymembers);
		readFile();
		return familymembers;
	}

	// Reads the file and adds those members to the familymembers list.
	public void readFile() {
		familymembers.clear();
		System.out.println("attempting to read file");

		try {

			BufferedReader buf = new BufferedReader(new FileReader(wac.getServletContext().getRealPath(FILE_NAME)));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println("made it");
				String[] tokens = line.split(",");
				String relation = tokens[0];
				String fname = tokens[1];
				String lname = tokens[2];
				int age = Integer.parseInt(tokens[3]);
				familymembers.add(new People(age, relation, fname, lname));
				System.out.println(familymembers);
			}
			buf.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// Deletes all members.
	@Override
	public boolean DeleteAll() {
		boolean delete = true;
		if (!familymembers.isEmpty()) {
			familymembers.clear();

		}
		try {
			FileWriter fw = new FileWriter((((wac.getServletContext()).getRealPath(FILE_NAME))));
			BufferedWriter bw = new BufferedWriter(fw);
			for (People people2 : familymembers) {
				bw.write(people2.toString());
				System.out.println("Done");
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return delete;
	}
	@Override
	public Map<String, ArrayList<People>> Relatives() {
		CurrentTree();
		List<People> siblings = new ArrayList<>();
		List<People> parents = new ArrayList<>();
		List<People> auntsUncles = new ArrayList<>();
		List<People> grandparents = new ArrayList<>();
		List<People> greatgrandparents = new ArrayList<>();
		List<People> children = new ArrayList<>();
		List<People> you = new ArrayList<>();
		List<People> spouse = new ArrayList<>();
		
		Map<String, ArrayList<People>> All = new HashMap<>();
		
		Iterator<People> iter = familymembers.iterator();
		while (iter.hasNext()) {
			People people = iter.next();
			switch (people.getRelation()) {
			case "You":
				you.add(people);
				break;
			case"Spouse":	
				spouse.add(people);
				break;
			case "Sister":
				siblings.add(people);
				break;
			case "Brother":
				siblings.add(people);
				break;
			case "Daughter":
				children.add(people);
				break;
			case "Son":
				children.add(people);
				break;
			case "Mother":
				parents.add(people);
				break;
			case "Father":
				parents.add(people);
				break;
			case "Aunt":
				auntsUncles.add(people);
				break;
			case "Uncle":
				auntsUncles.add(people);
				break;
			case "Grandmother M":
				grandparents.add(people);
				break;

			case "Grandmother F":
				grandparents.add(people);
				break;
			case "Grandfather M":
				grandparents.add(people);
				break;
			case "Grandfather F":
				grandparents.add(people);
				break;
			case "GreatGrandmother M":
				greatgrandparents.add(people);
				break;
			case "GreatGrandmother F":
				greatgrandparents.add(people);
				break;
			case "GreatGrandfather M":
				greatgrandparents.add(people);
				break;
			case "GreatGrandfather F":
				greatgrandparents.add(people);
				break;

			}
		}

		All.put("GreatGrandParents", (ArrayList<People>) greatgrandparents);
		All.put("GrandParents", (ArrayList<People>) grandparents);
		All.put("AuntsUncles", (ArrayList<People>) auntsUncles);
		All.put("Parents", (ArrayList<People>) parents);
		All.put("You", (ArrayList<People>) you);
		All.put("Spouse", (ArrayList<People>) spouse);
		All.put("Children", (ArrayList<People>) children);
		All.put("Siblings", (ArrayList<People>) siblings);
		
		return All;
	}

}