package sit.kmutt.ac.th.classicmodelsserivce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Customer;
import sit.kmutt.ac.th.classicmodelsserivce.repositories.CustomerRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class customerController {
    private final CustomerRepository repository;

    @Autowired
    public customerController(CustomerRepository repository) {
        this.repository = repository;
    } //constructure

//รับข้อมูลเเบบ Request Parameter
    @GetMapping("")

    public Page<Customer> getAllCustomers(   //or  List<Customer> getAllCustomers
            @RequestParam(defaultValue = "id") String sordBy,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10")Integer pagesize
            ){
        Sort sort = Sort.by(sordBy);
        return repository.findAll(PageRequest.of(page,pagesize,sort));
    }


        @GetMapping("/credit/{lower}/{upper}")
    public List<Customer> getAllCustomerCredit(@PathVariable BigDecimal lower , @PathVariable BigDecimal upper) {
        return repository.findAllByCreditLimitBetween(lower,upper);
        }


}
