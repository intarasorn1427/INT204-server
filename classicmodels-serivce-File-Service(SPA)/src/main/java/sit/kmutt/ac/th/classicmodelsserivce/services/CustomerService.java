package sit.kmutt.ac.th.classicmodelsserivce.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.kmutt.ac.th.classicmodelsserivce.dtos.SimpleCustomerDTO;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Customer;
import sit.kmutt.ac.th.classicmodelsserivce.repositories.CustomerRepository;

//เเบบhardcode
//@Service
//public class CustomerService {
//    @Autowired
//    private CustomerRepository repository;
//
//    public SimpleCustomerDTO getSimpleCustomerById(Integer id) {
//        return repository.findById(id).map(customer -> convertEntityToDto(customer)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " Does Not Exist !!!"));
//    }
//
//    private SimpleCustomerDTO convertEntityToDto(Customer customer) {
//        SimpleCustomerDTO simpleCustomerDTO = new SimpleCustomerDTO();
//        simpleCustomerDTO.setCustomerName(customer.getCustomerName());
//        simpleCustomerDTO.setCustomerName(customer.getPhone());
//        simpleCustomerDTO.setCustomerName(customer.getCity());
//        simpleCustomerDTO.setCustomerName(customer.getCountry());
//        simpleCustomerDTO.setSalesPerson(customer.getSalesRepEmployee().getFirstName() + ' ' + customer.getSalesRepEmployee().getLastName());
//        return simpleCustomerDTO;
//    }
//}

//เเบบใช้ dependency
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public SimpleCustomerDTO getSimpleCustomerById(Integer customerId) {
        Customer customer = repository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer id " + customerId + "Does Not Exist !!!"));
        return modelMapper.map(customer, SimpleCustomerDTO.class);
    }
}