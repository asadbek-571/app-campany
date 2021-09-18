package uz.pdp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.pdp.entity.Address;
import uz.pdp.entity.Company;
import uz.pdp.entity.Department;
import uz.pdp.entity.Worker;
import uz.pdp.model.AddressDto;
import uz.pdp.model.CompanyDto;
import uz.pdp.model.DepartmentDto;
import uz.pdp.model.WorkerDto;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface MapstructMapper {

    /**
     * Address
     */
    Address toAddress(AddressDto dto);

    Address toAddress(@MappingTarget Address address, AddressDto dto);

    AddressDto toAddressDto(Address address);

    /**
     * Company
     */
    Company toCompany(CompanyDto dto);

    Company toCompany(@MappingTarget Company company, CompanyDto dto);

    CompanyDto toCompanyDto(Company company);

    /**
     * Department
     */
    Department toDepartment(DepartmentDto dto);

    Department toDepartment(@MappingTarget Department department, DepartmentDto dto);

    DepartmentDto toDepartmentDto(Department department);

    /**
     * Worker
     */
    Worker toWorker(WorkerDto dto);

    Worker toWorker(@MappingTarget Worker worker, WorkerDto dto);

    WorkerDto toWorkerDto(Worker worker);
}
