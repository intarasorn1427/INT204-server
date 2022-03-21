package sit.kmutt.ac.th.classicmodelsserivce.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import sit.kmutt.ac.th.classicmodelsserivce.entities.Productline;


@Getter
@Setter
public class SimpleProductDTO {
    private String id;
    private String productName;
    @JsonIgnore
    private Productline productline;
    private Double msrp;

    public String getProductLine() {
        return productline.getId();
    }
    public String getImageUrl() {
        return id + ".jpg";
    }
}