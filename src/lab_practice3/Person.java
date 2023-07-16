package lab_practice3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String phone;
    private int age;

    private List<Role> roles = new ArrayList<>();

    public Person(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public void addRole(Role r){
        roles.add(r);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public List<Role> getRoles(){
        return roles;
    }


}
