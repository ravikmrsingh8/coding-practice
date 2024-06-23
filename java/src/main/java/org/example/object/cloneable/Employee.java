package org.example.object.cloneable;

import java.util.HashMap;
import java.util.Map;

public class Employee implements Cloneable {
    private String name;
    private Map<String, String> props = new HashMap<>();

    public Employee(String name) {
        this.name = name;
        this.props.put("A", "A->1");
    }

    public Map<String, String> getProps() {
        return this.props;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public Employee clone() {
        try {
            Employee e = (Employee) super.clone();
            e.props = new HashMap<>(this.props);
            return e;
        } catch (CloneNotSupportedException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Ravi");
        Employee cEmployee = employee.clone();
        System.out.println(cEmployee == employee);
        System.out.println(cEmployee.getName() == employee.getName());
        System.out.println(cEmployee.getProps() == employee.getProps());
        employee.getProps().put("Ravi", "1");
        System.out.println(cEmployee.getProps());
        System.out.println(employee.getProps());

    }
}
