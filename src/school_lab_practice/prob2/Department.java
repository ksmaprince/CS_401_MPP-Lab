package school_lab_practice.prob2;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Person> persons;
	
	public Department(String name) {
		this.name = name;
		this.persons = new ArrayList<Person>();

	}
	
	public void addPerson(Person p) {
		this.persons.add(p);
	}
	
	public List<Person> getPersons(){
		return this.persons;
	}
	
	public void showAllMembers() {
		
		/*for(Person p: persons) {
			System.out.print("Name: " + p.getName() + " phone: "+ p.getPhone()+ " age: "+ p.getAge() + " role: ");
			for(Role pRole: p.getRoles()) {
				System.out.print(pRole.getClass().getSimpleName() + " ");
			}
		System.out.println("\n");
		}*/

		persons.stream().forEach(p -> {
			System.out.print("Name: " + p.getName() + " phone: "+ p.getPhone()+ " age: "+ p.getAge() + " role: ");
			p.getRoles().stream().forEach(r -> System.out.print(r.getClass().getSimpleName()+ " "));
			System.out.println();
		});
	}
	public void showAllMembersLambda() {

		for(Person p: persons) {
			System.out.print("Name: " + p.getName() + " phone: "+ p.getPhone()+ " age: "+ p.getAge() + " role: ");
			for(Role pRole: p.getRoles()) {
				System.out.print(pRole.getClass().getSimpleName() + " ");
			}
		System.out.println("\n");
		}
	}
	
	public void unitsPerFaculty() {
		/*for(Person p :persons) {
			for(Role pRole: p.getRoles()) {
				if(pRole instanceof Faculty) {
					System.out.println("Name: " + p.getName() + " Units: " + pRole.getUnits() + "\n");
				}
			}
		}*/
		persons.stream().forEach(p -> {
			p.getRoles().stream().filter(r -> r instanceof Faculty).forEach(r -> System.out.println("Name: " + p.getName() + " Units: " + r.getUnits() + "\n"));
		});
	}

	public double getTotalSalary() {
		/*double sumSalary = 0.0;
		for(Person p: persons) {
			for(Role pRole: p.getRoles()) {
				sumSalary+= pRole.getSalary();
			}
		}
		return sumSalary;*/

		return persons.stream().flatMap(person -> person.getRoles().stream())
				.mapToDouble(role -> role.getSalary())
				.sum();
	}

	public void showStudentsByFaculty(String name){
		for (Person person : persons) {
			for (Role role : person.getRoles()) {
				if (role.getClass().getSimpleName().equals(name)){

				}
			}
		}
	}
}
