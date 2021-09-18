package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Worker

public interface WorkerRepo extends JpaRepository<Worker,Long> {
}
