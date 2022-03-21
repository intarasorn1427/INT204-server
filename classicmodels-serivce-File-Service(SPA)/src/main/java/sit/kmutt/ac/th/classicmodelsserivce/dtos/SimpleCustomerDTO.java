package sit.kmutt.ac.th.classicmodelsserivce.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SimpleCustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;
    private String salesPerson;  //methodจากclassที่สร้างใหม่

}
