package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.entity.Regulation;

public interface RegulationRepository extends JpaRepository<Regulation, Integer> {

	
}
