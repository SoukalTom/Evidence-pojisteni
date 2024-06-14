package cz.soukal.spring.repository;

import cz.soukal.spring.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    List<Insurance> findByClientId(Long id);
}
