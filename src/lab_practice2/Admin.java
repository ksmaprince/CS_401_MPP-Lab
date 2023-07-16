package lab_practice2;

public class Admin {
	//implement

    Department[] depts;

    public Admin(Department[] depts){
        this.depts = depts;
    }

    public String hourlyCompanyMessage() throws EmptyQueueException {
        StringBuilder companyMessage = new StringBuilder();
        for (Department dept : depts) {
            companyMessage.append(format(dept.getName(), dept.getQueue().dequeue()));
            companyMessage.append("\n");
        }
        return companyMessage.toString();
    }

    public String format(String name, String msg){
        return name+": "+msg;
    }
	
}
