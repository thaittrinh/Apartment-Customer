package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.com.entity.Apartment;


public interface ApartmentRepository extends JpaRepository<Apartment, String> {

}
