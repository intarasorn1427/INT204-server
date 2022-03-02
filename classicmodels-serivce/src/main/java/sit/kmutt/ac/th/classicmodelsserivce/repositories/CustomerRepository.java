package sit.kmutt.ac.th.classicmodelsserivce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {

}
