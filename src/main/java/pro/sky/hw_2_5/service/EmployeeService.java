package pro.sky.hw_2_5.service;


import org.springframework.stereotype.Service;
import pro.sky.hw_2_5.exception.EmployeeAlreadyAddedException;
import pro.sky.hw_2_5.exception.EmployeeNotFoundException;
import pro.sky.hw_2_5.exception.EmployeeStoragelsFullException;
import pro.sky.hw_2_5.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i), employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            if (Objects.isNull(employees.get(i))) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employees.set(index, employee);
        } else {
            throw new EmployeeStoragelsFullException();
        }
        return employee;
    }
    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i), employee)) {
                employees.remove(i);
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

