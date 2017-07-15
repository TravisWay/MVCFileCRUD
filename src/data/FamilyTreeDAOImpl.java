package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.PrinterMessageFromOperator;

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

	@PostConstruct
	public void init() {

		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				int id = Integer.parseInt(tokens[0]);
				String title = tokens[1].toLowerCase();
				String relation = tokens[2].toLowerCase();
				String fname = tokens[3];
				String lname = tokens[4];
				String sex = tokens[5];
				int age = Integer.parseInt(tokens[6]);
				familymembers.add(new People(id, title, age, relation, fname, lname, sex));
				System.out.println(familymembers);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<People> getPeopleByName(String name) {
		searchresults.clear();
		for (People people : familymembers) {
			if ((people.getFname().equals(name)) || (people.getLname().equals(name))) {
				searchresults.add(people);
			}
		}
		return searchresults;
	}

	@Override
	public List<People> getPeopleByRelation(String relation) {
		searchresults.clear();
		for (People people : familymembers) {
			if ((people.getRelation().contains(relation.toLowerCase()))) {
				searchresults.add(people);
			}
		}
		return searchresults;
	}

	@Override
	public List<People> addPeople(People people) {
		familymembers.add(people);
		
		return familymembers;
	}

	@Override
	public List<People> killPeople(People people) {
		familymembers.remove(people);
		return familymembers;
	}

	


	public List<People> getSearchresults() {
		return searchresults;
	}

	@Override
	public List<People> CurrentTree() {
		return familymembers;
		
	}

	


}