package sit.kmutt.ac.th.classicmodelsserivce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    List<Customer> findAllByCreditLimitBetween(BigDecimal lower , BigDecimal upper);
//    List<Customer> findAllByCityContainingAAndAddressLine1Containing(String city , String address);

}
