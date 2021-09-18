package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.entity.Address;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {


    private String directorName;

    private String corpNumber;

    private Long addressId;
}
