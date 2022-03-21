package sit.kmutt.ac.th.classicmodelsserivce.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.kmutt.ac.th.classicmodelsserivce.dtos.EmployeeDTO;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Employee;
import sit.kmutt.ac.th.classicmodelsserivce.services.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("")
    public List<EmployeeDTO> getAllEmplyee() {
        return service.getEmployees();
    }

    @PostMapping("")
    public Employee create(@RequestBody EmployeeDTO newEmployee) {
        return service.save(newEmployee);
    }


}
