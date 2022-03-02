package sit.kmutt.ac.th.classicmodelsserivce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Customer;
import sit.kmutt.ac.th.classicmodelsserivce.repositories.CustomerRepository;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/customer")
public class customerController {
    private final CustomerRepository repository;

    public customerController(CustomerRepository repository) {
        this.repository = repository;
    }

//รับข้อมูลเเบบ Request Parameter
    @GetMapping("")
    public Page<Customer> getAllCustomers(
            @RequestParam(defaultValue = "id") String sordBy,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10")Integer pagesize
            ){
        Sort sort = Sort.by(sordBy);
        return repository.findAll(PageRequest.of(page,pagesize,sort));
    }


}
