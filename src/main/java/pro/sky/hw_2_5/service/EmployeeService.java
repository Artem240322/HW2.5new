package pro.sky.hw_2_5.service;


import org.springframework.stereotype.Service;
import pro.sky.hw_2_5.exceptions.EmployeeAlreadyAddedException;
import pro.sky.hw_2_5.exceptions.EmployeeNotFoundException;
import pro.sky.hw_2_5.exceptions.EmployeeStoragelsFullException;
import pro.sky.hw_2_5.model.Employee;

import java.util.Objects;

@Service
public class EmployeeService {

    private final Employee[] employees = new Employee[10];

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i], employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            if (Objects.isNull(employees[i])) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employees[index] = employee;
        } else {
            throw new EmployeeStoragelsFullException();
        }
        return employee;
    }
    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i], employee)) {
                employees[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();

    }
    public Employee find(String name, String surname){
        Employee employee = new Employee(name, surname);
        for (Employee value : employees) {
            if (Objects.equals(value, employee)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}

