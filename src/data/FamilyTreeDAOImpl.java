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

	// private static final String FILE_NAME = "/WEB-INF/familytree.csv";

	private List<People> familymembers = new ArrayList<>();
	private List<People> searchresults = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		try {
			FileWriter fw = new FileWriter((wac.getServletContext()).getRealPath("output.csv"));
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
			
			if ((people.getRelation() != null)){
			if ((people.getRelation().contains(relation))) {
				searchresults.add(people);
			}
		}
		}
		return searchresults;
	}

	@Override
	public List<People> addPeople(People people) {
		familymembers.add(people);
		try {
			FileWriter fw = new FileWriter((wac.getServletContext()).getRealPath("output.csv"));
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
		return familymembers;
	}

	@Override
	public List<People> killPeople(People people) {
		Iterator<People> iter = familymembers.iterator();
		while (iter.hasNext()) {
			People people1 = iter.next();

			if ((people1.getFname()).equals(people.getFname()) && (people1.getLname()).equals(people.getLname())) {
				iter.remove();

			}
		}
		try {
			FileWriter fw = new FileWriter((wac.getServletContext()).getRealPath("output.csv"));
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
		return familymembers;
	}

	public List<People> getSearchresults() {
		return searchresults;
	}

	@Override
	public List<People> CurrentTree() {
		try (InputStream is = wac.getServletContext().getResourceAsStream("output.csv");
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String relation = tokens[0];
				String fname = tokens[1];
				String lname = tokens[2];
				// String sex = tokens[4];
				int age = Integer.parseInt(tokens[3]);
				familymembers.add(new People(age, relation, fname, lname));
				System.out.println(familymembers);
			}
			buf.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return familymembers;
	}

}