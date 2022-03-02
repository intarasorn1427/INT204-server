package sit.kmutt.ac.th.classicmodelsserivce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Employee;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Office;
import sit.kmutt.ac.th.classicmodelsserivce.repositories.OfficeRepository;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;
import java.util.Set;

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
    @GetMapping("/{officeCode}")               //path (api/offices/officeCode/1 (indexที่ต้องการค้นหา))
    public Office getOffice(@PathVariable String officeCode){
        return repository.findById(officeCode).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,officeCode+"Dose Not Exist!!!"));
    }
// List all employee for office id
    @GetMapping("/{officeCode}/employees")     //path (api/offices/officeCode/(1)/employees)
    public Set<Employee> getOfficeEmployees(@PathVariable String officeCode) {
        Office office = repository.findById(officeCode)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, officeCode + " does not exist !!!"));
        return office.getEmployees();
    }


    // Add new office
    //request body
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Office create(@RequestBody Office newOffice){
        return repository.saveAndFlush(newOffice);
    }


    //Delect office
    @DeleteMapping("/{officeCode}")
    public void delect(@PathVariable String officeCode) {  //รับ office id
        repository.findById(officeCode).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,officeCode+"Dose Not Exist!!!"));  //find
        repository.deleteById(officeCode);   //delect
    }


    //Update office
    @PutMapping("/{officeCode}")
    public Office update(@RequestBody Office updateOffice, @PathVariable String officeCode) {
        Office office = repository.findById(officeCode).map(o->mapOffice(o, updateOffice )) //ถ้าข้อมูลที่เพิ่มเข้ามามีใน db อยู่เเล้วจะอัพเดท
                .orElseGet(()->   //ถ้าข้อมูลที่เพิ่มเข้ามาไม่มีใน db จะเพิ่ม
                {
                    updateOffice.setId(officeCode);
                    return updateOffice;
                });
        return repository.saveAndFlush(office); //save
    }



    private Office mapOffice(Office existingOffice, Office updateOffice) {
        existingOffice.setAddressLine1(updateOffice.getAddressLine1());
        existingOffice.setAddressLine2(updateOffice.getAddressLine2());
        existingOffice.setCity(updateOffice.getCity());
        existingOffice.setCountry(updateOffice.getCountry());
        existingOffice.setPhone(updateOffice.getPhone());
        existingOffice.setPostalCode(updateOffice.getPostalCode());
        existingOffice.setState(updateOffice.getState());
        existingOffice.setTerritory(updateOffice.getTerritory());
        return existingOffice; }





//
//    @PutMapping("/{officeCode}")
//    public Office update(@RequestBody Office updateOffice,@PathVariable String officeCode){
//        Office office = repository.findById(officeCode).map(o -> mapaOffice(o , updateOffice))
//    }
//

}
