package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //nur ein interface, implementiert wird es automatisch vom framework
//
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
