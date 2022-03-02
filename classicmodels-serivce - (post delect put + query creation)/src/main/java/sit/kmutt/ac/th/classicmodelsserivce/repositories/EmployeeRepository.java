package sit.kmutt.ac.th.classicmodelsserivce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

}
