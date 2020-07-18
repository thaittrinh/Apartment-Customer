package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import poly.com.entity.TokenUser;

import java.util.Date;

public interface TokenRespository extends JpaRepository<TokenUser, Integer> {
    TokenUser findByToken(String token);

    @Modifying
    @Query("delete from TokenUser t where t.expiryDate <= ?1")
    void deleteAllByExpiryDate(Date now);
}