package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.entity.Address;
import uz.pdp.entity.Department;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerDto {


    private String name;

    private String phoneNumber;

    private Long addressId;

    private Long departmentId;
}
