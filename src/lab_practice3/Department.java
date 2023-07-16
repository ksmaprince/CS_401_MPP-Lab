package lab_practice3;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;

    List<Person> personList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public double getTotalSalary() {
        double totalSalary = 0;
        for (Person person : personList) {
            for (Role role : person.getRoles()) {
                if (role instanceof Faculty) {
                    Faculty f = (Faculty) role;
                    totalSalary += f.getSalary();
                }
                if (role instanceof Staff) {
                    Staff st = (Staff) role;
                    totalSalary += st.getSalary();
                }
            }
        }
        return totalSalary;
    }

    public void showAllMembers() {
        for (Person person : personList) {
            System.out.print("Name: " + person.getName() + ", Phone: " + person.getPhone() + ", Age: " + person.getAge() + ", Role: ");
            for (Role role : person.getRoles()) {
                System.out.print(role.getClass().getSimpleName() + "  ");
            }
            System.out.println();
        }
    }

    public void unitsPerFaculty() {
        System.out.println("List of Faculty and Units");
        for (Person person : personList) {
            for (Role role : person.getRoles()) {
                if (role instanceof Faculty) {
                    System.out.println("Name: " + person.getName() + "(" + role.getUnits() + " units)");
                }
            }
        }
    }

    public void addPerson(Person p) {
        personList.add(p);
    }
}
