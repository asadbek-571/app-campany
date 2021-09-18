package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
