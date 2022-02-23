package sit.kmutt.ac.th.classicmodelsserivce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Office;
import sit.kmutt.ac.th.classicmodelsserivce.repositories.OfficeRepository;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class officeController {
    @Autowired
    private OfficeRepository repository;

//    list All data in office repository
    @GetMapping("") //path
    public List<Office> getOffices() {
        return repository.findAll();
    }

//    list data follow officeCode
    @GetMapping("/{officeCode}")  //path
    public Office getOffice(@PathVariable String officeCode){
        return repository.findById(officeCode).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,officeCode+"Dose Not Exist!!!"));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Office create(@RequestBody Office newOffice) {
        return repository.saveAndFlush(newOffice);
    }

    @DeleteMapping("/{officeCode}")
    public void delete(@PathVariable String officeCode){
        repository.findById(officeCode).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,officeCode+"Does Not Exist!!"));
        repository.deleteById(officeCode);
    }
//
//    @PutMapping("/{officeCode}")
//    public Office update(@RequestBody Office updateOffice,@PathVariable String officeCode){
//        Office office = repository.findById(officeCode).map(o -> mapaOffice(o , updateOffice))
//    }
//

}
