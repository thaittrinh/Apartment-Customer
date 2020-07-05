package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.com.entity.PasswordResetToken;

public interface PasswordResetRespository extends JpaRepository<PasswordResetToken, Integer> {
    
}
