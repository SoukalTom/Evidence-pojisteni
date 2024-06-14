package cz.soukal.spring.repository;

import cz.soukal.spring.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
