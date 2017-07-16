package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
			FileWriter fw = new FileWriter((wac.getServletContext()).getRealPath(FILE_NAME));
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
		familymembers.add(people);
		System.out.println(familymembers);
		File file = new File(((wac.getServletContext()).getRealPath(FILE_NAME)));
		try {
			FileWriter fw = new FileWriter(file);
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
		readFile();
		System.out.println(familymembers);
		return people;
	}

	// Searches the list for the member with the matching data and deletes that
	// member from the list and rewrites the file.
	@Override
	public boolean killPeople(People people) {
		System.out.println(familymembers);
		boolean exists = false;
		Iterator<People> iter = familymembers.iterator();
		while (iter.hasNext()) {
			People people1 = iter.next();
			if ((people1.getFname()).equals(people.getFname()) && (people1.getLname()).equals(people.getLname())
					&& people1.getRelation().equals(people.getRelation())) {
				exists = true;
				iter.remove();
				break;
			}
		}
		File file = new File(((wac.getServletContext()).getRealPath(FILE_NAME)));
		try {
			FileWriter fw = new FileWriter(file);
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
		readFile();
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
		return familymembers;
	}

	// Reads the file and adds those members to the familymembers list.
	public void readFile() {
		familymembers.clear();
		System.out.println("attempting to read file " + familymembers);
		
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = null;
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
			is.close();
			buf.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// Deletes all members.
	@Override
	public boolean DeleteAll() {
		boolean delete = true;

		familymembers.clear();
		return delete;
	}

}